package com.google.devfest.repo

import com.google.devfest.model.Customer
import java.util.Random

/**
 * Created by herisulistiyanto on 2019-11-15.
 * KjokenKoddinger
 */

class CustomerRepo private constructor() {

    private val customers = mutableListOf<Customer>()

    val formattedName: String
        get() {
            val random = Random()
            val (first, last) = customers[random.nextInt(customers.size)]
            val lastName = last.getOrUnknown()
            return "$first $lastName"
        }

    init {
        with(customers) {
            add(Customer("Heri", "Sulis"))
            add(Customer("Fikri", null))
            add(Customer("Didik", ""))
        }
    }

    companion object {

        private var INSTANCE: CustomerRepo? = null

        @JvmStatic
        fun getInstance(): CustomerRepo {
            return INSTANCE ?: synchronized(CustomerRepo::class.java) {
                return@synchronized CustomerRepo()
            }.also {
                INSTANCE = it
            }
        }
    }
}

fun String?.getOrUnknown(): String {
    return if (this.isNullOrEmpty()) "Unknown" else this
}
