FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://${LINUX_VERSION}/0001-cp-board-add-dts-support-for-cp-board.patch"

# Config fragments
# SRC_URI += "file://${LINUX_VERSION}/fragment-01-adbd.cfg;subdir=fragments"

# KERNEL_CONFIG_FRAGMENTS += "${WORKDIR}/fragments/${LINUX_VERSION}/fragment-01-adbd.cfg"
