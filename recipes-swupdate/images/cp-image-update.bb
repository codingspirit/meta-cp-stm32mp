DESCRIPTION = "SWUpdate compound image"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit swupdate

SRC_URI = " \
    file://sw-description \
"

# images to build before building swupdate image
IMAGE_DEPENDS = "cp-image-core"

# images and files that will be included in the .swu image
SWUPDATE_IMAGES = "cp-image-core-openstlinux-eglfs-stm32mp1-cp"

SWUPDATE_IMAGES_FSTYPES[cp-image-core-openstlinux-eglfs-stm32mp1-cp] = ".ext4.gz"
