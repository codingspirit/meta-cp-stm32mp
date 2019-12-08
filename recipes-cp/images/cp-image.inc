AUTHOR = "Alex Li <lizhiqin46783937@live.com>"
LICENSE = "GPL-2.0"

LSB_RELASE_TIMESTAMP = "${DATE}-${TIME}"
LSB_RELASE_TIMESTAMP[vardepsexclude] += "DATE"
LSB_RELASE_TIMESTAMP[vardepsexclude] += "TIME"

update_lsbreleasedate() {
    if [ -f ${IMAGE_ROOTFS}${sysconfdir}/lsb-release ]; then
        sed -i 's/^DISTRIB_RELEASE=\(.*\)-snapshot-.*$/DISTRIB_RELEASE=\1-snapshot-'"${LSB_RELASE_TIMESTAMP}"'/' ${IMAGE_ROOTFS}${sysconfdir}/lsb-release
        sed -i 's/^DISTRIB_DESCRIPTION=\(.*\)-snapshot-.*\"/DISTRIB_DESCRIPTION=\1-snapshot-'"${LSB_RELASE_TIMESTAMP}"'\"/' ${IMAGE_ROOTFS}${sysconfdir}/lsb-release
    fi
}
ROOTFS_POSTPROCESS_COMMAND_append = "update_lsbreleasedate;"
