package homework;

import com.google.gson.Gson;
import homework.domain.Order;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

public class RestaurantOrders {
    // Этот блок кода менять нельзя! НАЧАЛО!
    private List<Order> orders;

    private RestaurantOrders(String fileName) {
        var filePath = Path.of("data", fileName);
        Gson gson = new Gson();
        try {
            orders = List.of(gson.fromJson(Files.readString(filePath), Order[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static RestaurantOrders read(String fileName) {
        var ro = new RestaurantOrders(fileName);
        ro.getOrders().forEach(Order::calculateTotal);
        return ro;
    }

    public List<Order> getOrders() {
        return orders;
    }
    // Этот блок кода менять нельзя! КОНЕЦ!

    //----------------------------------------------------------------------
    //------   Реализация ваших методов должна быть ниже этой линии   ------
    //----------------------------------------------------------------------

    public List<Order> getOrdersMin(int n) {
        return orders
                .stream()
                .sorted(Comparator.comparingDouble(Order::calculateTotal))
                .limit(n)
                .toList();
    }

    public List<Order> getOrdersMax(int n) {
        return orders
                .stream()
                .sorted(Comparator.comparingDouble(Order::calculateTotal).reversed())
                .limit(n)
                .toList();
    }

    public void printAllOrders() {
        orders.forEach(order -> System.out.println(order.toString()));
    }
}
