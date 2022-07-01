package com.example.app_challenge_meli
import org.junit.Test


internal class ExtensionsKtTest{


    @Test
    fun `convert price without decimals`(){
        //when
        val price :Double = 2.0
        val result = convertPrice(price)
        //then
        assert(result == "$ 2")
    }

    @Test
    fun `convert price with decimals`(){
        //when
        val price :Double = 2.9
        val result = convertPrice(price)
        //then
        assert(result == "$ 2,9")
    }

    @Test
    fun `convert big price with decimals`(){
        //when
        val price :Double = 22342314214.9
        val result = convertPrice(price)
        //then
        assert(result == "$ 22.342.314.214,9")
    }
}