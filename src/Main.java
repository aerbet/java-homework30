import homework.RestaurantOrders;
import homework.domain.Order;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        RestaurantOrders orders = RestaurantOrders.read("orders_100.json");

        orders.printAllOrders();

//        System.out.println(orders.getOrdersMin(3));

//        System.out.println(orders.getOrdersMax(3));

//        System.out.println(orders.getHomeDeliveryOrders());

//        System.out.println(orders.getHomeDeliveryMinMax());

//        System.out.println(orders.getFilteredTotal(1.0, 10.0));
//
//        System.out.println("Total orders sum: " + orders.getTotalSum());

//        System.out.println(orders.getUniqueEmails());

//        Map<String, List<Order>> sorted = orders.getUniqueClient();
//
//        for (Map.Entry entry : sorted.entrySet()) {
//            System.out.println("Клиент: " + entry.getKey() + entry.getValue());
//        }

//        Map<String, Double> clientTotal = orders.getSumOfClient();
//
//        for (Map.Entry entry: clientTotal.entrySet()) {
//            System.out.println(entry);
//        }

//        System.out.println(orders.getMaxSumClient());
//        System.out.println(orders.getMinSumClient());

        Map<String, Integer> selledItems = orders.getSelledItemsTotal();

        for (Map.Entry entry : selledItems.entrySet()) {
            System.out.printf("%nТовар: %-20s | кол-во продано: %s", entry.getKey(), entry.getValue());
        }


        //var orders = RestaurantOrders.read("orders_1000.json").getOrders();
        //var orders = RestaurantOrders.read("orders_10_000.json").getOrders();

        // протестировать ваши методы вы можете как раз в этом файле (или в любом другом, в котором вам будет удобно)
    }
}
