package com.example.fooditems

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewmodel:ViewModel() {
    private val _itemState= mutableStateOf(ItemState())
    val itemState:State<ItemState> =_itemState

    init {
        fetchItems()
    }
    private fun fetchItems(){
        viewModelScope.launch {
            try {
                val response= itemService.getResponse()
                    _itemState.value=itemState.value.copy(
                        itemlist = response.categories,
                        loading = false,
                        error = null
                    )
            }
            catch (e:Exception){
                _itemState.value=itemState.value.copy(
                    loading = false,
                    error = "${e.message}"
                )
            }
        }
    }

    data class ItemState(val loading:Boolean=true,
                         val itemlist:List<Category> = emptyList(),
                         val error:String? =null
    )
}