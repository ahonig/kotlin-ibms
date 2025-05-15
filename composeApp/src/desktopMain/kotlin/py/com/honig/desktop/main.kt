package py.com.honig.desktop

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*

fun main() = application {
    var showMainWindow by remember { mutableStateOf(false) }

    if (!showMainWindow) {
        // Splash window
        Window(
            onCloseRequest = {},
            undecorated = true,
            resizable = false,
            title = "",
            alwaysOnTop = true,
            state = WindowState(
                position = WindowPosition.Aligned(Alignment.Center),
            )

        ) {
            // This block is @Composable
            SplashScreen {
                showMainWindow = true
            }
        }
    } else {
        // Main app window
        Window(
            onCloseRequest = ::exitApplication,
            title = "IBMS",
            state = WindowState(
                position = WindowPosition.Aligned(Alignment.Center),
                placement = WindowPlacement.Maximized
            )

        ) {
            AppController(onExit = ::exitApplication)
        }
    }
}
