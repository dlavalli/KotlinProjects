package com.laval.lavalliere.kotlin

data class Position(var x: Int, var y: Int)    {
    operator fun plus(other: Position) : Position {
        return Position(x + other.x, y + other.y)
    }
}