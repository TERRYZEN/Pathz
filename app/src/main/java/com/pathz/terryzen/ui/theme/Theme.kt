package com.pathz.terryzen.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

private val NeobrutalistLightColorScheme = lightColorScheme(
    primary = SignalMint,
    secondary = VoltYellow,
    tertiary = ElectricSky,
    background = BgPageCream,
    surface = BgSurfaceWhite,
    surfaceVariant = BgRecessedSand,
    error = SignalCoral,
    onPrimary = InkBlack,
    onSecondary = InkBlack,
    onTertiary = InkBlack,
    onBackground = TextPrimaryInk,
    onSurface = TextPrimaryInk,
    onSurfaceVariant = TextSecondaryCharcoal,
    outline = InkBlack,
    outlineVariant = DividerCream
)

object PathzThemeTokens {
    val colors: PathzExtendedColors
        @Composable
        @ReadOnlyComposable
        get() = LocalPathzColors.current
}

/**
 * Locks Pathz to the Drafting Cream & Signal Mint Neobrutalism light palette
 * regardless of Android 12+ dynamic wallpaper colors or system dark mode.
 */
@Composable
fun PathzTheme(
    @Suppress("UNUSED_PARAMETER") darkTheme: Boolean = false,
    @Suppress("UNUSED_PARAMETER") dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalPathzColors provides PathzExtendedColors()) {
        MaterialTheme(
            colorScheme = NeobrutalistLightColorScheme,
            typography = Typography,
            content = content
        )
    }
}
