package com.vmbeshenov.bank.TempData

class HistoryOperations private constructor(val sum: Double, val category: String, val title_operation: String, val date_operation: String) {

    companion object {
        @JvmField
        val history_card = arrayOf(
                HistoryOperations(-1205.67, "Оплата товаров и услуг", "Читай-город", "12.05.2020 14:50:22"),
                HistoryOperations(-607.71, "Оплата товаров и услуг", "Пятерочка", "10.05.2020 11:25:18"),
                HistoryOperations(-311.98, "Оплата товаров и услуг", "Магнит", "12.05.2020 18:10:52")
        )
    }
}