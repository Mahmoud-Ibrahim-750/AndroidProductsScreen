package com.mis.route.androidproductsscreen.domain.models.product

import com.google.gson.annotations.SerializedName

data class Product(
    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("category")
    val category: String? = null,

    @field:SerializedName("price")
    val price: Double? = null,

    @field:SerializedName("discountPercentage")
    val discountPercentage: Double? = null,

    @field:SerializedName("rating")
    val rating: Double? = null,

    @field:SerializedName("stock")
    val stock: Int? = null,

    @field:SerializedName("tags")
    val tags: List<String?>? = null,

    @field:SerializedName("brand")
    val brand: String? = null,

    @field:SerializedName("sku")
    val sku: String? = null,

    @field:SerializedName("weight")
    val weight: Int? = null,

    @field:SerializedName("dimensions")
    val dimensions: ProductDimensions? = null,

    @field:SerializedName("warrantyInformation")
    val warrantyInformation: String? = null,

    @field:SerializedName("shippingInformation")
    val shippingInformation: String? = null,

    @field:SerializedName("availabilityStatus")
    val availabilityStatus: String? = null,

    @field:SerializedName("reviews")
    val reviews: List<ProductReview?>? = null,

    @field:SerializedName("returnPolicy")
    val returnPolicy: String? = null,

    @field:SerializedName("minimumOrderQuantity")
    val minimumOrderQuantity: Int? = null,

    @field:SerializedName("meta")
    val meta: ProductMeta? = null,

    @field:SerializedName("images")
    val images: List<String?>? = null,

    @field:SerializedName("thumbnail")
    val thumbnail: String? = null,
) {
    fun getPriceAfterDiscount(): Double {
        val priceValue = price ?: return 0.0
        val discountPercent = discountPercentage ?: 0.0

        val discountValue = priceValue * (discountPercent / 100)
        return price - discountValue
    }

    fun getReviewsAverage(): Double {
        val reviews = reviews ?: return 0.0

        var totalRating = 0.0
        var ratingCounter = 0
        for (review in reviews) {
            if (review?.rating == null) continue
            totalRating += review.rating
            ratingCounter++
        }

        return totalRating / ratingCounter
    }
}