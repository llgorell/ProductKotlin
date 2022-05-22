package com.example.productapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productapp.models.Product
import com.example.productapp.models.ProductX
import com.example.productapp.repositories.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val repository: ProductRepository) :
    ViewModel() {

    private var uiState = MutableStateFlow(emptyList<ProductX>())
    var stateFlow: StateFlow<List<ProductX>> = uiState

    init {
        viewModelScope.launch {
            getData {
                uiState.value = it.products
            }
        }
    }
    fun getData(OnResponse: (response: Product) -> Unit) {
        viewModelScope.launch {
            var response = repository.getProducts()
            OnResponse(response)
            uiState.value = response.products
        }

    }
}