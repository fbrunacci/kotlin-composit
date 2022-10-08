package composit.common.samples

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import composit.common.platform.Res
import composit.common.platform.painterResource
import kotlin.math.roundToInt

@Composable
fun SimpleMap() {

    // Offset Values for X and Y
    var offsetX by remember { mutableStateOf(0f) }
    var maxX = 800f
    var offsetY by remember { mutableStateOf(0f) }
    var maxY = 800f


    var tileSize = 64.dp

    var tilesRows = 50;
    var tilesColumns = tilesRows;

    var screenHeight: Dp = tileSize * tilesColumns
    var screenWidth: Dp = tileSize * tilesRows

    var mapSize: Dp = tileSize * (tilesColumns + 1)
    Box(
    Modifier.size(mapSize)
    ) {
        Column(
            Modifier
//            .height(screenHeight)
//            .width(screenWidth)
                .size(mapSize)
                //.background(Color.LightGray)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consumeAllChanges()
//                offsetX = max( 0f, min(offsetX + dragAmount.x, maxX))
//                offsetY = max( 0f, min(offsetY + dragAmount.y, maxY))
                        offsetX += dragAmount.x
                        offsetY += dragAmount.y
                    }
                }
        ) {
            Text(
                "x: $offsetX, y: $offsetY",
                modifier = Modifier.padding(2.dp)
            )
            Row(
                modifier = Modifier
                    .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                    .size(mapSize)
                    .padding(2.dp)
                    .graphicsLayer(rotationX = 60f, rotationY = 0f, rotationZ = 60f)
                    .background(Color.Blue)
            ) {
                repeat(tilesColumns) {
                    Column {
                        repeat(tilesRows) {
                            Tiles(TilesData(size = tileSize, color = Color.LightGray))
                        }
                    }
                }
            }
        }
    }
}