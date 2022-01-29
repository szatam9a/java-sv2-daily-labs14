package day01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {

    private List<Order> orders = new ArrayList<>();

    public void saveOrder(Order order) {
        orders.add(order);
    }

    public long counterOrderByStatus(String status) {
        return orders.stream().filter(e -> e.getStatus().equals(status)).count();
    }

    public List<Order> getOrdersBetweenDates(LocalDate from, LocalDate to) {
        return orders.stream().filter(e -> e.getOrderDate().isAfter(from) && e.getOrderDate().isBefore(to)).toList();
    }

    public boolean isThereOrderWithLessThanThisProduct(int number) {
        return orders.stream().anyMatch(e -> e.getProducts().size() < number);
    }

    public long countOrdersByStatus(String status) {
        return orders.stream().filter(e -> e.getStatus().equals(status)).count();
    }

    public List<Order> findOrdersByStatus(String status) {
        return orders.stream().filter(e -> e.getStatus().equals(status)).toList();
    }

    public Order getOrderWithMaxNumberOfProducts() {
        return orders.stream().sorted((e1, e2) -> e2.getProducts().size() - e1.getProducts().size()).findFirst().orElseThrow(() -> new IllegalArgumentException("No order"));
    }

    public List<Product> findProductsOverPrice(int price) {
        return orders.stream().flatMap(e -> e.getProducts().stream()).filter(e -> e.getPrice() > price).toList();
    }

    public List<Order> sortOrdersByStatusAndOrderDate() {
        return orders.stream().sorted(Comparator.comparing(Order::getStatus).thenComparing(Order::getOrderDate)).toList();
    }

    public List<Order> ordersContainsASpecificCategory(String category) {
        return orders.stream().
                filter(e -> e.getProducts().
                        stream().
                        anyMatch(x -> x.getCategory().
                                equals(category))).
                toList();
    }

}
