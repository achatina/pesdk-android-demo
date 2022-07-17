package com.photoeditorsdk.android.app

import android.graphics.Color
import android.os.Parcel
import android.os.Parcelable
import ly.img.android.pesdk.backend.model.config.ImageStickerAsset
import ly.img.android.pesdk.backend.model.state.layer.ImageStickerLayerSettings

internal open class CustomStickerLayerSetting : ImageStickerLayerSettings {

    constructor(parcel: Parcel) : super(parcel)

    constructor(stickerConfig: ImageStickerAsset) : super(stickerConfig)

    override fun flipHorizontal(): ImageStickerLayerSettings {
        val settings = super.flipHorizontal()
        setStickerSolidColor(listOf(Color.BLACK, Color.RED, Color.GREEN, Color.CYAN, Color.BLUE).random())
        updateColorMatrix()
        return settings
    }

    companion object CREATOR : Parcelable.Creator<CustomStickerLayerSetting> {
        override fun createFromParcel(parcel: Parcel): CustomStickerLayerSetting {
            return CustomStickerLayerSetting(parcel)
        }

        override fun newArray(size: Int): Array<CustomStickerLayerSetting?> {
            return arrayOfNulls(size)
        }
    }
}
