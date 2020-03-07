FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://51-wlan.network \
    file://wpa_supplicant-wlan0.conf \
    "
FILES_${PN} += " \
    ${systemd_unitdir}/network/51-wlan.network \
    ${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf \
"

SYSTEMD_AUTO_ENABLE = "disable"
SYSTEMD_SERVICE_${PN}_append = " wpa_supplicant@wlan0.service"

do_install_append() {
    install -d ${D}${sysconfdir}/wpa_supplicant/
    install -m 0600 ${WORKDIR}/wpa_supplicant-wlan0.conf ${D}${sysconfdir}/wpa_supplicant/

    if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
        install -d ${D}${systemd_unitdir}/network/
        install -m 0644 ${WORKDIR}/51-wlan.network ${D}${systemd_unitdir}/network/

        install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants/
        ln -s ${systemd_unitdir}/system/wpa_supplicant@.service \
        ${D}${sysconfdir}/systemd/system/multi-user.target.wants/wpa_supplicant@wlan0.service
    fi
}
