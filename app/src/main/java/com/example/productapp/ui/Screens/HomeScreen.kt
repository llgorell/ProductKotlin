@file:OptIn(ExperimentalFoundationApi::class)

package com.example.productapp.ui.Screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.productapp.models.ProductX
import com.example.productapp.ui.viewmodels.ProductViewModel
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun HomeScreen(viewModel: ProductViewModel = hiltViewModel()) {

    val data by viewModel.stateFlow.collectAsState()

    LazyVerticalGrid(cells = GridCells.Fixed(2), content = {

        items(data.size) { index ->
            ItemCard(product = data[index])
        }
    })
}

@Composable
fun ItemCard(product: ProductX) {
    Card(

        modifier = Modifier
            .height(140.dp)
            .fillMaxWidth()
            .padding(16.dp)
            .shadow(
                4.dp,
                shape = RoundedCornerShape(8.dp),
                clip = true
            )
    ) {
        GlideImage( // CoilImage, FrescoImage
            contentScale = ContentScale.Fit,
            imageModel = product.images?.get(0),
            // shows a shimmering effect when loading an image.
            shimmerParams = ShimmerParams(
                baseColor = MaterialTheme.colors.background,
                highlightColor = Gray,
                durationMillis = 700,
                dropOff = 0.65f,
                tilt = 20f,
            )
            // shows an error text message when request failed.
//            failure = {
//                Text(text = "image request failed.")
//            }
        )

    }
}