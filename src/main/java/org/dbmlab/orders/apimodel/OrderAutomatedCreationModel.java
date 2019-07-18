package org.dbmlab.orders.apimodel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class OrderAutomatedCreationModel {

    @NotBlank
    private String customerName;
    @Min(value = 1)
    private Integer ordersCount;
    @Min(value = 1)
    private Integer itemsPerOrderCount;
    private String defaultItemsNotes;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(Integer ordersCount) {
        this.ordersCount = ordersCount;
    }

    public Integer getItemsPerOrderCount() {
        return itemsPerOrderCount;
    }

    public void setItemsPerOrderCount(Integer itemsPerOrderCount) {
        this.itemsPerOrderCount = itemsPerOrderCount;
    }

    public String getDefaultItemsNotes() {
        return defaultItemsNotes;
    }

    public void setDefaultItemsNotes(String defaultItemsNotes) {
        this.defaultItemsNotes = defaultItemsNotes;
    }
}