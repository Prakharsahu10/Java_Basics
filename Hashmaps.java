public class Hashmaps {
    public static void main(String[] args) {
        // Create a HashMap to hold String keys and Integer values
        java.util.HashMap<String, Integer> map = new java.util.HashMap<>();

        // Add key-value pairs to the HashMap
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        // Print the HashMap
        System.out.println("HashMap: " + map);

        // Access a value by key
        int value = map.get("Two"); // Accessing the value for key "Two"
        System.out.println("Value for key 'Two': " + value);

        // Remove a key-value pair by key
        map.remove("One"); // Removing the key-value pair with key "One"
        System.out.println("HashMap after removal: " + map);

        // Get the size of the HashMap
        int size = map.size();
        System.out.println("Size of HashMap: " + size);
    }
}
