package com.otakusenpai.sg2.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.otakusenpai.sg2.StarFishCollectorAlpha

object DesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
        val myGame = StarFishCollectorAlpha()
        val launcher = LwjglApplication(myGame, "Starfish Collector", 800, 600)
    }
}
