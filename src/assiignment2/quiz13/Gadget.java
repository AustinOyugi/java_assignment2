/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assiignment2.quiz13;

/**
 *
 * @author austin-oyugi
 */
public class Gadget {

    private int itemNumber;
    private String description;
    private double price;

    public Gadget(int itemNumber, String description, double price) {
        this.itemNumber = itemNumber;
        this.description = description;
        this.price = price;
    }

    Gadget() {
        
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Gadget{" + "itemNumber=" + itemNumber + ", description=" + description + ", price=" + price + '}';
    }
    
    
}
