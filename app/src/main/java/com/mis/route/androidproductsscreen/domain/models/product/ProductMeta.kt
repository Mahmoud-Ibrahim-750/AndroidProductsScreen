package com.mis.route.androidproductsscreen.domain.models.product

import com.google.gson.annotations.SerializedName

data class ProductMeta(
    @field:SerializedName("createdAt")
    val createdAt: String? = null,

    @field:SerializedName("updatedAt")
    val updatedAt: String? = null,

    @field:SerializedName("barcode")
    val barcode: String? = null,

    @field:SerializedName("qrCode")
    val qrCode: String? = null
)