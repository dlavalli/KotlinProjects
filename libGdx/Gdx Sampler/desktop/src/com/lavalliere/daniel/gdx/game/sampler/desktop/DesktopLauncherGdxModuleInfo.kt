package com.lavalliere.daniel.gdx.game.sampler.desktop

import kotlin.jvm.JvmStatic
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.lavalliere.daniel.gdx.game.sampler.GdxSamplerGame
import com.lavalliere.daniel.gdx.game.sampler.ModuleInfoSample

object DesktopLauncherGdxModuleInfo {
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = LwjglApplicationConfiguration()
        LwjglApplication(ModuleInfoSample(), config)
    }
}