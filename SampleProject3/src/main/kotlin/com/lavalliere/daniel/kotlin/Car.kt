package com.lavalliere.daniel.kotlin

class Car : Vehicule {
    override val MakeName = "Ford"
    // override fun go() { super.go() }
    // override fun stop() { super.stop() }
    // override fun getMpg(): Int { return super.getMpg() }

    override fun getDoors(): Int {
        return 5
    }
}