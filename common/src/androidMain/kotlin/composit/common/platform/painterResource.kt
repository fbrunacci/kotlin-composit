package composit.common.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

import composit.common.R

@Composable
actual fun painterResource(res: String): Painter {
    val id = drawableId(res)
    return androidx.compose.ui.res.painterResource(id)
}

private fun drawableId(res: String): Int {
    val imageName = res.substringAfterLast("/").substringBeforeLast(".")
    val drawableClass = R.drawable::class.java
    val field = drawableClass.getDeclaredField(imageName)
    val idValue = field.get(drawableClass) as Integer
    return idValue.toInt()
}