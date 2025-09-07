public class loops {
    public static void main(String[] args) {
        
        /*
         * FOR LOOP:
         * - Used when you know the exact number of iterations
         * - Has 3 parts: initialization, condition, increment/decrement
         * - Syntax: for(initialization; condition; increment/decrement)
         * - Most compact loop structure
         * - Initialization happens only once at the beginning
         * - Condition is checked before each iteration
         * - Increment/decrement happens after each iteration
         */
        System.out.println("For loop:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration: " + i);
        }

        /*
         * WHILE LOOP:
         * - Used when you don't know the exact number of iterations
         * - Condition is checked BEFORE executing the loop body
         * - If condition is false initially, loop body never executes
         * - Also called "entry-controlled loop"
         * - Variable initialization must be done before the loop
         * - Variable increment/decrement must be done inside the loop body
         * - Risk of infinite loop if increment/decrement is forgotten
         */
        System.out.println("\nWhile loop:");
        int j = 1;  // Initialize variable before loop
        while (j <= 5) {  // Check condition before entering loop
            System.out.println("Iteration: " + j);
            j++;  // Don't forget to increment, or it becomes infinite loop!
        }

        /*
         * DO-WHILE LOOP:
         * - Used when you want the loop body to execute at least once
         * - Condition is checked AFTER executing the loop body
         * - Also called "exit-controlled loop"
         * - Guarantees minimum one execution even if condition is false
         * - Useful for menu-driven programs or user input validation
         * - Semicolon (;) is required after while condition
         */
        System.out.println("\nDo-while loop:");
        int k = 1;  // Initialize variable before loop
        do {
            System.out.println("Iteration: " + k);
            k++;  // Increment inside loop body
        } while (k <= 5);  // Condition checked after execution (note the semicolon)
    }
}
