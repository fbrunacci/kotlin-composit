package composit.common.samples

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import composit.common.getPlatformName
import composit.common.platform.Res
import composit.common.platform.painterResource

@Composable
fun InitApp() {
    var text by remember { mutableStateOf("Hello, World!") }
    val platformName = getPlatformName()

    Column {
        Button(onClick = {
            text = "Hello, ${platformName}"
        }) {
            Text(text)
        }
        Image(
            painterResource(Res.drawable.p1),
            contentDescription = null,
            modifier = Modifier.size(38.dp)
        )
    }
}
