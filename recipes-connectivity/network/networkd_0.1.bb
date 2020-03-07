AUTHOR = "Alex Li <lizhiqin46783937@live.com>"
SUMMARY = "systemd-networkd configs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PV = "0.1"

SRC_URI = " \
    file://10-eth.network \
    file://51-wlan.network \
"

FILES_${PN} = " \
    ${systemd_unitdir}/network/10-eth.network \
    ${systemd_unitdir}/network/51-wlan.network \
"

do_install() {
    if ${@bb.utils.contains('MACHINE_FEATURES','ethernet','true','false',d)}; then
        install -d ${D}${systemd_unitdir}/network/
        install -m 0644 ${WORKDIR}/10-eth.network ${D}${systemd_unitdir}/network/
    fi

    if ${@bb.utils.contains('MACHINE_FEATURES','wifi','true','false',d)}; then
        install -d ${D}${systemd_unitdir}/network/
        install -m 0644 ${WORKDIR}/51-wlan.network ${D}${systemd_unitdir}/network/
    fi
}
