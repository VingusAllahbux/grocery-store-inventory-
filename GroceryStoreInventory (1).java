import java.util.Scanner;

class Product {
    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public String toString() {
        return "Product Name: " + name + ", Price: " + price + ", Quantity: " + quantity;
    }
}

class GroceryStore {
    Product[] array = new Product[3];

    public void addProduct(Product product, int index) {
        if (index >= 0 && index < array.length) {
            array[index] = product;
        } else {
            System.out.println("Error: Invalid index");
        }
    }

    public void sellProduct(String productName) {
        for (Product product : array) {
            if (product != null && product.name.equalsIgnoreCase(productName)) {
                if (product.quantity > 0) {
                    product.quantity -= 1;
                    System.out.println("Reduced 1 " + productName);
                } else {
                    System.out.println("The product is out of stock");
                }
                return;
            }
        }
        System.out.println("The product is not available");
    }

    public void searchProduct(String search) {                     //will search the product in array
        for (Product product : array) {
            if (product != null && product.name.equalsIgnoreCase(search)) {
                System.out.println(product.toString());
                return;
            }
        }
        System.out.println("Product not found");
    }
}

public class GroceryStoreInventory {
    public static void main(String[] args) {
        Product obj1 = new Product("tomato", 23.67, 2);
        Product obj2 = new Product("potato", 20.45, 5);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the name of the new vegetable to add in the inventory: ");
        String newProduct = sc.nextLine();
        System.out.println("Enter the price of the new vegetable: ");
        double newProductPrice = sc.nextDouble();
        System.out.println("Enter the quantity of the new vegetable: ");
        int newProductQuantity = sc.nextInt();

        // Consume the leftover newline
        sc.nextLine();

        Product obj3 = new Product(newProduct, newProductPrice, newProductQuantity);
        GroceryStore store = new GroceryStore();

        store.addProduct(obj1, 0); // adding obj1 in array
        store.addProduct(obj2, 1); // adding obj2 in array
        store.addProduct(obj3, 2); // adding new product

        store.searchProduct("Tomato");
        store.sellProduct("Tomato");
        System.out.println("There are 3 items in the stock at the moment there detail is");
        System.out.println("product1: " + store.array[0].name+"\n    price:"+store.array[0].price+"\n    quantity:"+store.array[0].quantity);
        System.out.println("product2: " + store.array[1].name+"\n    price:"+store.array[1].price+"\n    quantity:"+store.array[1].quantity);
        System.out.println("new Product: " + store.array[2].name +"\n    new Product Price: " + store.array[2].price + "\n    new Product Quantity: " + store.array[2].quantity);
        System.out.println("array: " + store.array); // not giving array but giving its reference because it add reference of object not object itself

        System.out.println("Enter the name of the product that you want to search: ");
        String searchProduct = sc.nextLine();
        store.searchProduct(searchProduct);
    }
}
