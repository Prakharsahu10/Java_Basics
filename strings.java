public class strings {
    public static void main(String[] args) {
        String greeting = "Hello";
        String name = "Alice";

        // Concatenation
        String message = greeting + ", " + name + "!";
        System.out.println(message); // Output: Hello, Alice!

        // Length
        System.out.println("Length of message: " + message.length()); // Output: Length of message: 13

        // Character at index
        System.out.println("Character at index 7: " + message.charAt(7)); // Output: Character at index 7: A

        // Substring
        System.out.println("Substring from index 7 to 12: " + message.substring(7, 12)); // Output: Substring from index 7 to 12: Alice

        // Replace
        String newMessage = message.replace("Alice", "Bob");
        System.out.println(newMessage); // Output: Hello, Bob!

        // To Upper Case
        System.out.println("Upper case: " + message.toUpperCase()); // Output: Upper case: HELLO, ALICE!

        // To Lower Case
        System.out.println("Lower case: " + message.toLowerCase()); // Output: Lower case: hello, alice!

        // Trim
        String spacedString = "   Hello World!   ";
        System.out.println("Trimmed string: '" + spacedString.trim() + "'"); // Output: Trimmed string: 'Hello World!'

        // Split
        String[] words = message.split(", ");
        System.out.println("First word: " + words[0]); // Output: First word: Hello
        System.out.println("Second word: " + words[1]); // Output: Second word: Alice!
    }
}
