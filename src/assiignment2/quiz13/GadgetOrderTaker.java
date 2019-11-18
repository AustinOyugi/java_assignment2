/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assiignment2.quiz13;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author austin-oyugi
 */
public class GadgetOrderTaker {

    private static int personIndex = 1;
    private static int orderNumber = 101;
    private static final List<Gadget> gadgets = Arrays.asList(
            new Gadget(101, "Electric hand warmer", 12.99),
            new Gadget(124, "Battery-opperated plant waterer", 7.55),
            new Gadget(256, "Gerbil trimmer", 9.99),
            new Gadget(512, "Talking bookmark", 6.89)
    );
    private static final Map<Order, Map<Gadget, Integer>> allOrders = new HashMap<>();

    public static void main(String args[]) throws OrderException {
        while (personIndex <= 4) {
            String name = JOptionPane.showInputDialog(null, "Enter Name");
            String address = JOptionPane.showInputDialog(null, "Enter Address");

            Order order = new Order();

            order.setOrderNumber(orderNumber += 1);
            order.setCustomerName(name);
            order.setAddress(address);

            Map<Gadget, Integer> boughtGadgets = new HashMap<>();

            int maxGadgets = 0;
            Gadget gadget;
            while (maxGadgets <= 4) {
                gadget = new Gadget();

                int itemNumber = 0, quantity = 1;

                if (maxGadgets > 4) {
                    break;
                }
                try {

                    itemNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "EnterItemNumber"));

                    if (itemNumber == 999) {
                        break;
                    }

                    quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter quantity"));
                } catch (NumberFormatException e) {
                    e.getLocalizedMessage();
                }

                final int itemNumberF = itemNumber;

                Gadget boughtGadget = gadgets.stream()
                        .filter(g -> itemNumberF == g.getItemNumber())
                        .findAny()
                        .orElse(null);

                if (boughtGadget == null) {
                    throw new OrderException("Invalid Item Number");
                }

                gadget.setItemNumber(boughtGadget.getItemNumber());
                gadget.setDescription(boughtGadget.getDescription());
                gadget.setPrice(boughtGadget.getPrice() * quantity);

                boughtGadgets.put(gadget, quantity);
                maxGadgets++;
            }

            List<Integer> itemNumbers = boughtGadgets.keySet().stream()
                    .map(Gadget::getItemNumber)
                    .collect(Collectors.toList());

            order.setItemNumbers(itemNumbers);

            double totalPrice[] = new double[1];

            boughtGadgets.forEach((Gadget k, Integer v) -> {
                if (true) {
                    totalPrice[0] += v * k.getPrice();
                }
            });

            order.setTotal(totalPrice[0]);

            if (totalPrice[0] <= 24.99) {
                order.setShippingAndHandlingFee(5.55);
            } else if (totalPrice[0] <= 49.99) {
                order.setShippingAndHandlingFee(8.55);
            } else {
                order.setShippingAndHandlingFee(11.55);
            }

            allOrders.put(order, boughtGadgets);

            personIndex++;
        }

        printOrders(allOrders);
    }

    public static void printOrders(Map<Order, Map<Gadget, Integer>> allOrders) {
        for (Map.Entry<Order, Map<Gadget, Integer>> order : allOrders.entrySet()) {
            System.out.println("---------------------------------------------------------------");

            System.out.println(MessageFormat.format("Order Number: {0}\nCustomer Name: {1}\nAddress: {2}\nItem Number: {3}", 
                    order.getKey().getOrderNumber(), order.getKey().getCustomerName(), order.getKey().getAddress(),
                    order.getKey().getItemNumbers()));

            order.getValue().entrySet().stream().map((gadgetsAndQuantity) -> {
                System.out.print(gadgetsAndQuantity.getValue().toString());
                return gadgetsAndQuantity;
            }).map((gadgetsAndQuantity) -> {
                System.out.print("  quantity="+gadgetsAndQuantity.getValue() );
                return gadgetsAndQuantity;
            }).forEach((_item) -> {
                System.out.println();
            });
            
            System.out.println(
                    "Total: " + order.getKey().getTotal() + "\n"
                    + "Shipping and Handling fee: " + order.getKey().getShippingAndHandlingFee()
            );

            System.out.println("---------------------------------------------------------------");
        }
    }
}