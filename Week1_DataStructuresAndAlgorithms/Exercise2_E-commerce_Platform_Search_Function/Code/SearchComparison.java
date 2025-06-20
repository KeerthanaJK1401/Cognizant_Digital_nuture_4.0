package ecommercePlatform;
	import java.util.Arrays;
	import java.util.Comparator;

	public class SearchComparison {

	    // Linear search
	    public static Product linearSearch(Product[] products, String name) {
	        for (Product p : products) {
	            if (p.productName.equalsIgnoreCase(name)) {
	                return p;
	            }
	        }
	        return null;
	    }

	    // Binary search (requires sorted array)
	    public static Product binarySearch(Product[] products, String name) {
	        int left = 0, right = products.length - 1;
	        while (left <= right) {
	            int mid = (left + right) / 2;
	            int compare = products[mid].productName.compareToIgnoreCase(name);
	            if (compare == 0)
	                return products[mid];
	            else if (compare < 0)
	                left = mid + 1;
	            else
	                right = mid - 1;
	        }
	        return null;
	    }

	    public static void main(String[] args) {
	        Product[] products = {
	            new Product(101, "Laptop", "Electronics"),
	            new Product(102, "Shoes", "Fashion"),
	            new Product(103, "Smartphone", "Electronics"),
	            new Product(104, "Backpack", "Accessories"),
	            new Product(105, "Watch", "Fashion")
	        };

	        // Linear Search
	        System.out.println("Linear Search:");
	        Product result1 = linearSearch(products, "Watch");
	        System.out.println(result1 != null ? result1 : "Product not found");

	        // Sort before Binary Search
	        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

	        // Binary Search
	        System.out.println("\nBinary Search:");
	        Product result2 = binarySearch(products, "Watch");
	        System.out.println(result2 != null ? result2 : "Product not found");
	    }
	}


