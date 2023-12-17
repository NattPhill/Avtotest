package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun amountWithCommissionForMasterCard() {
        val typeCard = "MasterCard"
        val transfer = 100_000
        val previous = 0

        val result = commission(typeCard, transfer, previous)

        assertEquals(620, result)
    }
    @Test
    fun errorDailyLimitForMaestro() {
        val typeCard = "Maestro"
        val transfer = 250_000
        val previous = 0

        val result = commission(typeCard, transfer, previous)

        assertEquals(ERROR_LIMIT, result)
    }
    @Test
    fun errorMonthlyLimitForMaestro() {
        val typeCard = "Maestro"
        val transfer = 100_000
        val previous = 550_000

        val result = commission(typeCard, transfer, previous)

        assertEquals(ERROR_LIMIT, result)
    }
    @Test
    fun amountWithoutCommissionForMasterCard() {
        val typeCard = "MasterCard"
        val transfer = 50_000
        val previous = 0

        val result = commission(typeCard, transfer, previous)

        assertEquals(0, result)
    }

    @Test
    fun amountWithCommissionForVisa() {
        val typeCard = "Visa"
        val transfer = 100_000
        val previous = 0

        val result = commission(typeCard, transfer, previous)

        assertEquals(750, result)
    }
    @Test
    fun errorDailyLimitForMir() {
        val typeCard = "Мир"
        val transfer = 220_000
        val previous = 0

        val result = commission(typeCard, transfer, previous)

        assertEquals(ERROR_LIMIT, result)
    }
    @Test
    fun errorMonthlyLimitForVisa() {
        val typeCard = "Visa"
        val transfer = 120_000
        val previous = 550_000

        val result = commission(typeCard, transfer, previous)

        assertEquals(ERROR_LIMIT, result)
    }
    @Test
    fun amountWithCommissionForVKPay() {
        val typeCard = "VK Pay"
        val transfer = 10_000
        val previous = 0

        val result = commission(typeCard, transfer, previous)

        assertEquals(0, result)
    }
    @Test
    fun errorDailyLimitForVKPay() {
        val typeCard = "VK Pay"
        val transfer = 20_000
        val previous = 0

        val result = commission(typeCard, transfer, previous)

        assertEquals(ERROR_LIMIT, result)
    }
    @Test
    fun errorMonthlyLimitForVKPay() {
        val typeCard = "VK Pay"
        val transfer = 10_000
        val previous = 40_000

        val result = commission(typeCard, transfer, previous)

        assertEquals(ERROR_LIMIT, result)
    }
    @Test
    fun errorTipeForAnotherCard() {
        val typeCard = "UnionPay"
        val transfer = 50_000
        val previous = 0

        val result = commission(typeCard, transfer, previous)

        assertEquals(ERROR_TIPE, result)
    }
}