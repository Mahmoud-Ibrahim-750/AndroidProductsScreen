package com.mis.route.androidproductsscreen.ui.screens.products.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mis.route.androidproductsscreen.databinding.ItemProductBinding
import com.mis.route.androidproductsscreen.domain.models.product.Product

class ProductsAdapter(
    private var products: List<Product?> = emptyList()
) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {


    inner class ViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product?) {
            binding.product = product
            binding.productPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            binding.executePendingBindings()
        }
    }


    inner class ProductDiffUtilCallback(
        private val oldList: List<Product>,
        private val newList: List<Product>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size
        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(
            oldItemPosition: Int,
            newItemPosition: Int,
        ): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

        override fun areContentsTheSame(
            oldItemPosition: Int,
            newItemPosition: Int,
        ): Boolean {
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]

            return when {
                oldItem.id != newItem.id -> false
                oldItem.title != newItem.title -> false
                oldItem.description != newItem.description -> false
                oldItem.category != newItem.category -> false
                oldItem.price != newItem.price -> false
                oldItem.discountPercentage != newItem.discountPercentage -> false
                oldItem.rating != newItem.rating -> false
                oldItem.stock != newItem.stock -> false
                oldItem.tags != newItem.tags -> false
                oldItem.brand != newItem.brand -> false
                oldItem.sku != newItem.sku -> false
                oldItem.weight != newItem.weight -> false
                oldItem.dimensions != newItem.dimensions -> false
                oldItem.warrantyInformation != newItem.warrantyInformation -> false
                oldItem.shippingInformation != newItem.shippingInformation -> false
                oldItem.availabilityStatus != newItem.availabilityStatus -> false
                oldItem.reviews != newItem.reviews -> false
                oldItem.returnPolicy != newItem.returnPolicy -> false
                oldItem.minimumOrderQuantity != newItem.minimumOrderQuantity -> false
                oldItem.meta != newItem.meta -> false
                oldItem.images != newItem.images -> false
                oldItem.thumbnail != newItem.thumbnail -> false
                else -> true
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    fun bindProducts(newProducts: List<Product?>) {
        val diffUtilCallback =
            ProductDiffUtilCallback(products.filterNotNull(), newProducts.filterNotNull())
        val diffResult = DiffUtil.calculateDiff(diffUtilCallback)
        products = newProducts
        diffResult.dispatchUpdatesTo(this)
    }
}