package com.lavalliere.daniel.gdx.game.sampler

import com.badlogic.gdx.Application
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.lavalliere.daniel.gdx.game.sampler.util.Logger
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ScreenUtils

// ie:  ApplicationAdapter is an abstract class that implements ApplicationListener interface
//      without any implementations of the methods
class ModuleInfoSample : ApplicationAdapter() {
    // LibGdx has 6 interfaces (ie: modules) that provide us interaction with the OS :
    //      Application (Gdx.app),
    //      Files (Gdx.files),
    //      Input (Gdx.input),
    //      Net (Gdx.net) ,
    //      Audio (Gdx.audio),
    //      Graphics (Gdx.graphics)

    // These modules can be accessed using static fields from Gdx class

    companion object {
        @JvmStatic
        private val log = Logger<ModuleInfoSample>()
    }

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG
        log.debug("app=${Gdx.app}")
        log.debug("audio=${Gdx.audio}")
        log.debug("input=${Gdx.input}")
        log.debug("files=${Gdx.files}")
        log.debug("net=${Gdx.net}")
        log.debug("graphics=${Gdx.graphics}")
    }
}