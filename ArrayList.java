public class ArrayList {
    public static void main(String[] args) {
        // Create an ArrayList to hold String elements
        java.util.ArrayList<String> list = new java.util.ArrayList<>();

        // Add elements to the ArrayList
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Print the ArrayList
        System.out.println("ArrayList: " + list);

        // Access an element by index
        String fruit = list.get(1); // Accessing the second element (index 1)
        System.out.println("Element at index 1: " + fruit);

        // Remove an element by index
        list.remove(0); // Removing the first element (index 0)
        System.out.println("ArrayList after removal: " + list);

        // Get the size of the ArrayList
        int size = list.size();
        System.out.println("Size of ArrayList: " + size);
    }
}
