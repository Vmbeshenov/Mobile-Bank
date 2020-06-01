package com.diploma.bank.TempData;

public class HistoryOperations {

    private double sum;
    private String category;
    private String title_operation;
    private String date_operation;

    public static final HistoryOperations[] history_card = {
            new HistoryOperations(-1205.67, "Оплата товаров и услуг", "Читай-город", "12.05.2020 14:50:22"),
            new HistoryOperations(-607.71, "Оплата товаров и услуг", "Пятерочка", "10.05.2020 11:25:18"),
            new HistoryOperations(-311.98, "Оплата товаров и услуг", "Магнит", "12.05.2020 18:10:52")
    };

    private HistoryOperations(double sum, String category, String title_operation, String date_operation){
        this.sum = sum;
        this.category = category;
        this.title_operation = title_operation;
        this.date_operation = date_operation;
    }

    public double getSum() {
        return sum;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle_operation() {
        return title_operation;
    }

    public String getDate_operation() {
        return date_operation;
    }
}