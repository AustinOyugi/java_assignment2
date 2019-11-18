/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assiignment2.quiz13;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author austin-oyugi
 */
public class Order 
{
    private int orderNumber;
    private String customerName;
    private String address;
    private List<Integer> itemNumbers = new ArrayList<>(4);
    private double total;
    private double shippingAndHandlingFee;

    public Order(int orderNumber, String customerName, String address, double total, double shippingAndHandlingFee) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.address = address;
        this.total = total;
        this.shippingAndHandlingFee = shippingAndHandlingFee;
    }

    Order() {
        
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public List<Integer> getItemNumbers() {
        return itemNumbers;
    }

    public double getTotal() {
        return total;
    }

    public double getShippingAndHandlingFee() {
        return shippingAndHandlingFee;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setItemNumbers(List<Integer> itemNumbers) {
        this.itemNumbers = itemNumbers;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setShippingAndHandlingFee(double shippingAndHandlingFee) {
        this.shippingAndHandlingFee = shippingAndHandlingFee;
    }

    @Override
    public String toString() {
        return "Order{" + "orderNumber=" + orderNumber + ", customerName=" + customerName + 
                ", address=" + address + ", itemNumbers=" + itemNumbers + ", total=" + total +
                ", shippingAndHandlingFee=" + shippingAndHandlingFee + '}';
    }
    
}
