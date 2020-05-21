package com.paymob.demo

import android.os.Bundle



class Tests {

    fun  getStrings(bundle: Bundle):String {
        val df = bundle.keySet().map {
            Pair(it, bundle[it])
        }
      return  df.joinToString { pair -> "${pair.first}:${pair.second}" }
    }
    fun getNamr(): String {
        return 'a'.rangeTo('z').random().toString()
    }

    fun adslkfasdjflk(): Int {

        val rabitList = mutableListOf<Rabit>()
        rabitList.add(Rabit(getNamr(), 2))
        var year = 4
        while (year > 0) {
            rabitList.map { }
            val newBorn = mutableListOf<Rabit>()
            rabitList.forEach {
                --it.monthRemaing
                if (it.monthRemaing == 0) {
                    it.monthRemaing = 1
                    newBorn.add(Rabit(getNamr(), 2))
                }
            }
            rabitList += newBorn
            year--
        }
        return rabitList.size
    }


    data class Rabit(var name: String, var monthRemaing: Int)
}