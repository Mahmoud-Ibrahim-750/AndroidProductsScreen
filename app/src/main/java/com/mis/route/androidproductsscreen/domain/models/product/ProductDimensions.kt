package com.mis.route.androidproductsscreen.domain.models.product

import com.google.gson.annotations.SerializedName

data class ProductDimensions(
    @field:SerializedName("width")
    val width: Double? = null,

    @field:SerializedName("height")
    val height: Double? = null,

    @field:SerializedName("depth")
    val depth: Double? = null
)