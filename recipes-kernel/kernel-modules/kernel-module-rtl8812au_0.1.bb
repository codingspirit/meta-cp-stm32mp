SUMMARY = "Driver for rtl8811au/8812au/8821au"
LICENSE = "GPL-2.0"
PV = "0.1"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit module

${PN}_REPO = "github.com/abperiasamy/rtl8812AU_8821AU_linux.git"
SRCREV_${PN} = "4235b0ec7d7220a6364586d8e25b1e8cb99c36f1"

SRC_URI = " \
  git://${${PN}_REPO};name=${PN};protocol=https;nobranch=1;destsuffix=git/${PN} \
  file://0001-modify-makefile-to-support-yocto.patch \
  "

S = "${WORKDIR}/git/${PN}"

RPROVIDES_${PN} += "kernel-module-rtl8812au"
