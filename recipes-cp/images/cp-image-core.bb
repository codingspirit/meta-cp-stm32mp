AUTHOR = "Alex Li <lizhiqin46783937@live.com>"
SUMMSUMMARY = "Core image suitble for no-graphic develoopment"

include recipes-cp/images/cp-image.inc

inherit core-image

IMAGE_LINGUAS = "en-us"

IMAGE_FEATURES += "\
    package-management  \
    ssh-server-dropbear \
    "

DEV_SUPPORT = "android-tools"

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
    "
