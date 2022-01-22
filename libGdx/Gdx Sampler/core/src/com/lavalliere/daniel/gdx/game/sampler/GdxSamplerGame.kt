package com.lavalliere.daniel.gdx.game.sampler

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ScreenUtils

class GdxSamplerGame : ApplicationAdapter() {
    var batch: SpriteBatch? = null  // Some classes, like SpriteBatch Cannot be initialized/used
                                    // until the application starts booting (ie: when framework boots itself
    var img: Texture? = null

    override fun create() {
        batch = SpriteBatch()
        img = Texture("badlogic.jpg")
    }

    override fun render() {
        ScreenUtils.clear(1f, 0f, 0f, 1f)
            // ie: Corresponds to calls
            // Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
            // Gdx.gl.glClear(0GL20.GL_COLOR_BUFFER_BIT)

        batch!!.begin()
        batch!!.draw(img, 0f, 0f)
        batch!!.end()
    }

    override fun dispose() {
        batch!!.dispose()
        img!!.dispose()
    }
}