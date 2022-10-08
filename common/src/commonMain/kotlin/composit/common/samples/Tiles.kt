package composit.common.samples

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class TilesData(var color: Color = Color.DarkGray, var size: Dp = 64.dp) {}

@Composable
fun Tiles(tilesData: TilesData) {
    var tilesColor = remember { mutableStateOf(tilesData.color) }
    Box(
        Modifier
            .size(tilesData.size)
            .background(tilesColor.value)
            .clickable {
                tilesColor.value = Color.Black
            }
    )
}

