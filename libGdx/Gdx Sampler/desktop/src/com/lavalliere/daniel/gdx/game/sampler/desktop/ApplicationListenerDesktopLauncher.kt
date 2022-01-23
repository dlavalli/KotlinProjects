package com.lavalliere.daniel.gdx.game.sampler.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.lavalliere.daniel.gdx.game.sampler.ApplicationListenerSample
import com.lavalliere.daniel.gdx.game.sampler.GdxSamplerGame

// Initially will have single launcher per sub projects
object ApplicationListenerDesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = LwjglApplicationConfiguration()
        LwjglApplication(ApplicationListenerSample(), config)
    }
}