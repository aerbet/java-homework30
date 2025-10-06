import homework.RestaurantOrders;
import homework.domain.Order;

public class Main {

    public static void main(String[] args) {
        var orders = RestaurantOrders.read("orders_100.json").getOrders();

        orders.forEach(System.out::println);

        var filtered = orders
                .stream()
                .map(Order::calculateTotal)
                .toList();

        filtered.forEach(System.out::println);


        //var orders = RestaurantOrders.read("orders_1000.json").getOrders();
        //var orders = RestaurantOrders.read("orders_10_000.json").getOrders();

        // протестировать ваши методы вы можете как раз в этом файле (или в любом другом, в котором вам будет удобно)
    }
}
