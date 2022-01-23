package com.lavalliere.daniel.gdx.game.sampler

import com.badlogic.gdx.Application
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Gdx
import com.lavalliere.daniel.gdx.game.sampler.util.Logger
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ScreenUtils

class ApplicationListenerSample : ApplicationListener {

    companion object {
        // libGdx Library logging support
        @JvmStatic   // JVM Static Final when compile to java byte code
        private val log = Logger<ApplicationListenerSample>()
    }

    private var renderInterrupted = true

    // Used to initialize the game and load resources (textures, fonts etc)
    override fun create() {

        // Set the application logging level  (better to configure)
        Gdx.app.logLevel = Application.LOG_DEBUG

        // Library logging support
        log.debug("create()")
    }

    // Used to habdle setting new screen size when windows is resized and application started
    override fun resize(width: Int, height: Int) {
        log.debug("resize()")
    }

    // USed to render the game elementd, called 60 times/frames per sec (60Hz)
    override fun render() {
        if (renderInterrupted) {
            log.debug("render()")
            renderInterrupted = false
        }
    }

    // Use to save game state when looses focus which does nto involve actual game being paused unless requested by developper
    override fun pause() {
        log.debug("pause()")
        renderInterrupted = true
    }

    // Used to restore game state when regain focus which does not involve actual game being unpaused unless requested by developper
    override fun resume() {
        log.debug("pause()")
        renderInterrupted = true
    }

    // Used to dispose of resources and cleanup
    override fun dispose() {
        log.debug("dispose()")
    }
}