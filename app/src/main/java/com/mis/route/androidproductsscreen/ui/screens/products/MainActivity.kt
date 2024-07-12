package com.mis.route.androidproductsscreen.ui.screens.products

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mis.route.androidproductsscreen.databinding.ActivityMainBinding
import com.mis.route.androidproductsscreen.ui.screens.products.adapter.ProductsAdapter
import com.mis.route.androidproductsscreen.ui.screens.products.model.MainViewModel

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()

    private lateinit var productsAdapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        configureWindowInsets()

        initializeProductsRecyclerView()
        viewModel.getProducts()
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.productsList.observe(this) { products ->
            products?.let { productsAdapter.bindProducts(it) }
        }
    }

    private fun configureWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initializeProductsRecyclerView() {
        productsAdapter = ProductsAdapter()
        binding.productsRv.adapter = productsAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}