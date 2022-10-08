package composit.common.preview

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import composit.common.samples.SimpleMap
import composit.common.samples.Tiles
import composit.common.samples.TilesData

@Composable
@Preview
fun TilesPreview() {
    Tiles(TilesData())
}

@Composable
@Preview
fun SimpleMapPreview() {
    SimpleMap()
}