package com.example.fooditems

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun foodItemScreen() {
    val mainViewModelObj: MainViewmodel = viewModel()
    val objState by mainViewModelObj.itemState

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            objState.loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            objState.error != null -> {
                Text(
                    text = "Error Ocurred: ${objState.error}",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            else-> {
                itemGridView(list = objState.itemlist)
            }
        }
    }
}
    @Composable
    fun itemGridView(list:List<Category>){
        LazyVerticalGrid(columns =GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize()) {
            items(list){item->
                soloItemView(item=item)
            }
        }
    }

    @Composable
    fun soloItemView(item: Category){
        Column(modifier = Modifier.padding(8.dp).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = rememberAsyncImagePainter(model = item.strCategoryThumb),
                contentDescription = "",
                modifier = Modifier.fillMaxSize().aspectRatio(1f))

            Text(text = "${item.idCategory}:${item.strCategory}",
                style = MaterialTheme.typography.bodyMedium)
        }
    }
