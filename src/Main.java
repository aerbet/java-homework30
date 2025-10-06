import homework.RestaurantOrders;
import homework.domain.Order;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        RestaurantOrders restaurantOrders = RestaurantOrders.read("orders_100.json");

//        restaurantOrders.printAllOrders();

//        System.out.println(restaurantOrders.getOrdersMin(3));

//        System.out.println(restaurantOrders.getOrdersMax(3));

//        System.out.println(restaurantOrders.getHomeDeliveryOrders());

//        System.out.println(restaurantOrders.getHomeDeliveryMinMax());

//        System.out.println(restaurantOrders.getFilteredTotal(1.0, 10.0));
//
//        System.out.println("Total orders sum: " + restaurantOrders.getTotalSum());

        System.out.println(restaurantOrders.getUniqueEmails());

        //var orders = RestaurantOrders.read("orders_1000.json").getOrders();
        //var orders = RestaurantOrders.read("orders_10_000.json").getOrders();

        // протестировать ваши методы вы можете как раз в этом файле (или в любом другом, в котором вам будет удобно)
    }
}
