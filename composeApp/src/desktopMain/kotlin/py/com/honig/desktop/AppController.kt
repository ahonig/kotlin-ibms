package py.com.honig.desktop

import androidx.compose.runtime.*
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.application


@Composable
fun AppController(onExit: () -> Unit
) {
    var screenState by remember { mutableStateOf("splash") }

    when (screenState) {
        "splash" -> SplashScreen { screenState = "login" }
        "login"  -> LoginScreen(
            onLoginSuccess = { screenState = "app" },
            onCancel = onExit
        )
        "app"    -> App()
    }
}
