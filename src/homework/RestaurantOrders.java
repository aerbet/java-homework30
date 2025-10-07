package homework;

import com.google.gson.Gson;
import homework.domain.Customer;
import homework.domain.Item;
import homework.domain.Order;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

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

    public Map<String, Integer> getSelledItemsTotal() {
        return orders
                .stream()
                .flatMap(order -> order.getItems().stream())
                .collect(groupingBy(Item::getName, summingInt(Item::getAmount)));
    }

    public String getMinSumClient() {
        return getSumOfClient()
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }

    public String getMaxSumClient() {
        return getSumOfClient()
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }

    public Map<String, Double> getSumOfClient() {
        return orders
                .stream()
                .collect(groupingBy(order -> order.getCustomer().getFullName(),
                        summingDouble(Order::calculateTotal)));
    }

    public Map<String, List<Order>> getUniqueClient() {
        return orders
                .stream()
                .collect(groupingBy(order -> order.getCustomer().getFullName()));
    }

    public List<String> getUniqueEmails() {
        return orders.stream()
                .map(order -> order.getCustomer().getEmail())
                .distinct()
                .toList();
    }

    public double getTotalSum() {
        return orders
                .stream()
                .mapToDouble(Order::calculateTotal)
                .sum();
    }

    public List<Order> getFilteredTotal(double minOrderTotal, double maxOrderTotal) {
        return orders
                .stream()
                .filter(order -> {
                    double total = order.calculateTotal();
                    return total > minOrderTotal && total < maxOrderTotal;
                }).toList();
    }

    public List<Order> getHomeDeliveryMinMax() {
        var min = getHomeDeliveryOrders()
                .stream()
                .min(Comparator.comparingDouble(Order::calculateTotal))
                .get();
        var max = getHomeDeliveryOrders()
                .stream()
                .max(Comparator.comparingDouble(Order::calculateTotal))
                .get();

        return List.of(min, max);
    }

    public List<Order> getHomeDeliveryOrders() {
        return orders
                .stream()
                .filter(Order::isHomeDelivery)
                .toList();
    }

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
