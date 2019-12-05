# This recipe is based on android-tools provided by meta-openembedded
# Modified for better support to adbd on Linux
AUTHOR = "Alex Li <lizhiqin46783937@live.com>"
DESCRIPTION = "Different utilities from Android - corressponding configuration files"
SECTION = "console/utils"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://android-debug-bridge-setup"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/android-debug-bridge-setup ${D}${bindir}
}
