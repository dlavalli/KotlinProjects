package com.lavalliere.daniel.gdx.game.sampler.util

import com.badlogic.gdx.utils.Logger

// First version to setup logger
// calling with:    private val log = Logger(ApplicationListenerSample::class.java)
// fun <T : Any> Logger(clazz : Class<T>) : Logger = Logger(clazz.simpleName, Logger.DEBUG)

// Second version to setup logger using generics
// calling with:    private val log = Logger<ApplicationListenerSample>()
inline fun <reified T : Any> Logger() : Logger = Logger(T::class.java.simpleName, Logger.DEBUG)