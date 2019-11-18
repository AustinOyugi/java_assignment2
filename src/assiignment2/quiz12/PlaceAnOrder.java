/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assiignment2.quiz12;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 * W
 *
 * @author austin-oyugi
 */
public class PlaceAnOrder {

    private static final Map<Integer, Double> items = new HashMap<>();
   
    public static void main(String args[]) throws OrderException {
        init();
        Map<Integer, Integer> boughtItems = new HashMap<>();
        OrderMessages messages = new OrderMessages();

        boolean exitStatus = true;

        while (exitStatus) {
            try {
                int itemNumber, quantity;

                itemNumber = Integer.parseInt(JOptionPane.showInputDialog("item Number"));

                if (itemNumber < 0) {
                    throw new OrderException(messages.getMessage(2));
                } else if (itemNumber > 999) {
                    throw new OrderException(messages.getMessage(3));
                }

                if (!items.containsKey(itemNumber)) {
                    throw new OrderException(messages.getMessage(6));
                }

                try {
                    quantity = Integer.parseInt(JOptionPane.showInputDialog("Quantity"));

                    if (quantity < 1) {
                        throw new OrderException(messages.getMessage(4));
                    } else if (quantity > 12) {
                        throw new OrderException(messages.getMessage(5));
                    }
                } catch (NumberFormatException e) {
                    throw new OrderException(messages.getMessage(1));
                }

                if (boughtItems.containsKey(itemNumber)) {
                    int quantityBought = boughtItems.get(itemNumber) + quantity;
                    boughtItems.replace(itemNumber, quantityBought);
                } else {
                    boughtItems.put(itemNumber, quantity);
                }

                if (Integer.parseInt(JOptionPane.showInputDialog("0 -> exit, any number continue")) == 0) {
                    exitStatus = false;
                }
            } catch (NumberFormatException e) {
                throw new OrderException(messages.getMessage(0));
            }
        }

        double price = 0;

        for (Map.Entry<Integer, Integer> entry : boughtItems.entrySet()) {
            price += items.get(entry.getKey()) * entry.getValue();
        }

        JOptionPane.showMessageDialog(null, "The total is " + String.format("%.2f", price));
        
        boughtItems.clear();
    }

    public void addItem(int itemName, double price) {
        items.put(itemName, price);
    }

    private static final void init() {
        items.put(111, 0.89);
        items.put(222, 1.47);
        items.put(333, 2.43);
        items.put(444, 5.99);
    }
}
