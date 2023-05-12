package com.comunidadedevspace.taskbeats

import kotlin.random.Random

interface MyCountRepository {

    fun sum(): Int

    fun sub(p1: Int, p2: Int): Int
}

class MyCountRepositoryImpl(private val numbersProvider : MyNumbersProvider) : MyCountRepository {

    override fun sum(): Int {
        val p1 = numbersProvider.getNumbers()
        val p2 = numbersProvider.getNumbers()
        return p1 + p2
    }

    override fun sub(p1: Int, p2: Int): Int = p1 - p2

}

interface MyNumbersProvider {

    fun getNumbers(): Int

}

class MyNumbersProviderImpl : MyNumbersProvider {
    override fun getNumbers(): Int {
        return Random.nextInt(from = 0, until = 100)
    }
}