import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PrimitiveIterator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) throws Exception {

        List<Product> store = new LinkedList<Product>(
                Arrays.asList(
                        //          ID  Name    Department     Price
                        new Product(0,"Laptop","Electronics", 1099.99f),
                        new Product(1,"Hat","Clothes", 5f),
                        new Product(2,"Stove","Kitchen", 800.70f),
                        new Product(3,"Camera","Electronics", 50.50f),
                        new Product(4,"Fridge","Kitchen", 960.25f),
                        new Product(5,"Sweater","Clothes", 25f),
                        new Product(6,"Scanner","Electronics", 346.60f),
                        new Product(7,"Microwave","Kitchen", 490.10f),
                        new Product(8,"Pants","Clothes", 10.30f)
                )
        );

        //Print each of the products
        System.out.println("Original List:");
        store.forEach(product -> System.out.println(product));

        //Filter and print the Products which belongs to the Electronics department
        System.out.println("\n\nOnly Electronics:");
        Predicate<Product> electronicProduct = (Product product)-> "Electronics".equals(product.department);
        System.out.println(store.stream().filter(electronicProduct).collect(Collectors.toList()));

        //Remove Products which belongs to the Kitchen department
        Predicate<Product> kitchenRemover = (Product product)-> "Kitchen".equals(product.department);
        store.removeIf(kitchenRemover);

        //Print each of the products
        System.out.println("\n\nWithout Kitchen department, list:");
        store.forEach(product -> System.out.println(product));

        //Print products that are cheaper than $800.00
        Predicate<Product> cheapProducts = (Product product)-> product.price < 800f;
        System.out.println("\n\nCheap Products:");
        System.out.println(store.stream().filter(cheapProducts).collect(Collectors.toList()));

        //Remove Products that are more expensive than $700.00
        Predicate<Product> expensiveProduct = (Product product)-> product.price > 700f;
        store.removeIf(expensiveProduct);
        //Print each of the products
        System.out.println("\n\nWithout Expensive products, list:");
        store.forEach(product -> System.out.println(product));
    }
}

