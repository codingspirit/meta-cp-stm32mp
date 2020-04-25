AUTHOR = "Alex Li <lizhiqin46783937@live.com>"
SUMMARY = "Core image suitble for no-graphic develoopment"

include recipes-cp/images/cp-image.inc

inherit core-image

IMAGE_LINGUAS = "en-us"

IMAGE_FEATURES += "\
    package-management  \
    ssh-server-dropbear \
    "

IMAGE_FSTYPES_append = " ext4.gz"

DEV_SUPPORT = "android-tools"

DRV_SUPPORT = "kernel-module-rtl8812au"

NET_SUPPORT = "networkd wpa-supplicant"

SWU_SUPPORT = "swupdate swupdate-www swupdate-tools u-boot-fw-utils"

#
# INSTALL addons
#
CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-framework-core-base    \
    packagegroup-framework-tools-base   \
    \
    ${@bb.utils.contains('COMBINED_FEATURES', 'optee', 'packagegroup-optee-core', '', d)}   \
    ${@bb.utils.contains('COMBINED_FEATURES', 'optee', 'packagegroup-optee-test', '', d)}   \
    ${DEV_SUPPORT} \
    ${DRV_SUPPORT} \
    ${NET_SUPPORT} \
    ${SWU_SUPPORT} \
"
