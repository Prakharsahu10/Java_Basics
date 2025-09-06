class operators {
    public static void main(String[] args) {
        int number1 = 12;
        int number2 = 6;

        //addition
        System.out.println(number1 + number2); // 18

        //subtraction
        System.out.println(number1 - number2); // 6

        //multiplication
        System.out.println(number1 * number2); // 72

        //division
        System.out.println(number1 / number2); // 2

        //modulus
        System.out.println(number1 % number2); // 0

        //increment
        System.out.println(++number1); // 13
        System.out.println(number1++); // 13

        //decrement
        System.out.println(--number2); // 5
        System.out.println(number2--); // 5

        System.out.println(number1); // 14
        System.out.println(number2); // 4

        //equal to

        System.out.println(number1 == number2); // false
        //not equal to
        System.out.println(number1 != number2); // true

        //greater than
        System.out.println(number1 > number2); // true
        //less than
        System.out.println(number1 < number2); // false

        //greater than or equal to
        System.out.println(number1 >= number2); // true
        //less than or equal to
        System.out.println(number1 <= number2); // false

        //logical AND
        System.out.println((number1 > number2) && (number1 != number2)); // true
        //logical OR
        System.out.println((number1 > number2) || (number1 == number2)); // true
        //logical NOT
        System.out.println(!(number1 > number2)); // false
        
    }
}