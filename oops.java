// Comprehensive Object-Oriented Programming (OOP) Examples in Java
// This file demonstrates all major OOP concepts with detailed explanations

// ========================== ABSTRACTION ==========================
// Abstract class - cannot be instantiated directly
// Used to provide a common base with some implemented and some abstract methods
abstract class Animal {
    protected String name;
    protected int age;
    
    // Constructor for abstract class
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Concrete method - implemented in abstract class
    public void sleep() {
        System.out.println(name + " is sleeping...");
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract void makeSound();
    public abstract void move();
}

// Interface - defines a contract that implementing classes must follow
// All methods in interface are implicitly public and abstract (before Java 8)
interface Playable {
    // Interface constants are implicitly public, static, and final
    int MAX_ENERGY = 100;
    
    // Abstract methods that must be implemented
    void play();
    void rest();
    
    // Default method (Java 8+) - provides default implementation
    default void checkEnergy() {
        System.out.println("Checking energy level...");
    }
}

// ========================== ENCAPSULATION ==========================
// Encapsulation - bundling data and methods together and hiding internal details
class Dog extends Animal implements Playable {
    // Private fields - data hiding (encapsulation)
    private String breed;
    private double energy;
    private boolean isHungry;
    
    // Constructor - special method to initialize objects
    public Dog(String name, int age, String breed) {
        super(name, age); // Call parent constructor
        this.breed = breed;
        this.energy = MAX_ENERGY;
        this.isHungry = false;
    }
    
    // Getter methods - provide controlled access to private fields
    public String getBreed() {
        return breed;
    }
    
    public double getEnergy() {
        return energy;
    }
    
    public boolean isHungry() {
        return isHungry;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    // Setter methods - provide controlled modification of private fields
    public void setBreed(String breed) {
        if (breed != null && !breed.trim().isEmpty()) {
            this.breed = breed;
        }
    }
    
    public void setHungry(boolean hungry) {
        this.isHungry = hungry;
    }
    
    // Private helper method - internal implementation detail
    private void reduceEnergy(double amount) {
        energy = Math.max(0, energy - amount);
        if (energy < 30) {
            isHungry = true;
        }
    }
    
    // Implementation of abstract method from Animal class
    @Override
    public void makeSound() {
        System.out.println(name + " the " + breed + " says: Woof! Woof!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " is running around happily!");
        reduceEnergy(10);
    }
    
    // Implementation of interface methods
    @Override
    public void play() {
        if (energy > 20) {
            System.out.println(name + " is playing fetch!");
            reduceEnergy(15);
        } else {
            System.out.println(name + " is too tired to play.");
        }
    }
    
    @Override
    public void rest() {
        energy = Math.min(MAX_ENERGY, energy + 25);
        isHungry = false;
        System.out.println(name + " is resting and recovering energy.");
    }
    
    // Method overloading - same method name with different parameters
    public void eat() {
        eat("dog food");
    }
    
    public void eat(String food) {
        System.out.println(name + " is eating " + food);
        energy = Math.min(MAX_ENERGY, energy + 20);
        isHungry = false;
    }
}

// ========================== INHERITANCE ==========================
// Cat class inherits from Animal (single inheritance)
class Cat extends Animal implements Playable {
    private boolean isIndoor;
    private double energy;
    
    public Cat(String name, int age, boolean isIndoor) {
        super(name, age); // Inherit from parent
        this.isIndoor = isIndoor;
        this.energy = MAX_ENERGY;
    }
    
    // Getter and setter for encapsulation
    public boolean isIndoor() {
        return isIndoor;
    }
    
    public void setIndoor(boolean indoor) {
        this.isIndoor = indoor;
    }
    
    public double getEnergy() {
        return energy;
    }
    
    // Override parent's abstract method
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow! Meow!");
    }
    
    @Override
    public void move() {
        if (isIndoor) {
            System.out.println(name + " is gracefully walking around the house");
        } else {
            System.out.println(name + " is prowling around outside");
        }
        energy -= 8;
    }
    
    @Override
    public void play() {
        System.out.println(name + " is playing with a ball of yarn!");
        energy -= 12;
    }
    
    @Override
    public void rest() {
        energy = Math.min(MAX_ENERGY, energy + 30);
        System.out.println(name + " is napping in a sunny spot.");
    }
    
    // Cat-specific method
    public void climb() {
        if (energy > 15) {
            System.out.println(name + " is climbing a tree!");
            energy -= 15;
        } else {
            System.out.println(name + " is too tired to climb.");
        }
    }
}

// ========================== POLYMORPHISM ==========================
// Bird class demonstrating method overriding
class Bird extends Animal {
    private boolean canFly;
    private double energy;
    private static final int BIRD_MAX_ENERGY = 100; // Bird's own energy constant
    
    public Bird(String name, int age, boolean canFly) {
        super(name, age);
        this.canFly = canFly;
        this.energy = BIRD_MAX_ENERGY;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " chirps: Tweet! Tweet!");
    }
    
    @Override
    public void move() {
        if (canFly) {
            System.out.println(name + " is flying through the sky!");
        } else {
            System.out.println(name + " is hopping on the ground.");
        }
        energy -= 10;
    }
    
    // Method overloading - compile-time polymorphism
    public void fly() {
        fly(10);
    }
    
    public void fly(int distance) {
        if (canFly && energy > 20) {
            System.out.println(name + " flies " + distance + " meters!");
            energy -= (distance * 0.5);
        } else if (!canFly) {
            System.out.println(name + " cannot fly!");
        } else {
            System.out.println(name + " is too tired to fly.");
        }
    }
    
    public boolean canFly() {
        return canFly;
    }
    
    public double getEnergy() {
        return energy;
    }
}

// Utility class demonstrating static methods and variables
class AnimalShelter {
    // Static variable - belongs to class, not instance
    private static int totalAnimalsCreated = 0;
    
    // Static method - can be called without creating an instance
    public static void displayInfo() {
        System.out.println("=".repeat(50));
        System.out.println("ANIMAL SHELTER MANAGEMENT SYSTEM");
        System.out.println("Total animals created: " + totalAnimalsCreated);
        System.out.println("=".repeat(50));
    }
    
    public static void incrementAnimalCount() {
        totalAnimalsCreated++;
    }
    
    // Static method demonstrating polymorphism
    public static void makeAllAnimalsSound(Animal[] animals) {
        System.out.println("\n--- All animals making sounds ---");
        for (Animal animal : animals) {
            animal.makeSound(); // Runtime polymorphism - calls appropriate method
        }
    }
    
    // Method demonstrating interface polymorphism
    public static void makePlayableAnimalsPlay(Playable[] playables) {
        System.out.println("\n--- Playable animals playing ---");
        for (Playable playable : playables) {
            playable.play(); // Calls appropriate implementation
        }
    }
}

// Main class demonstrating all OOP concepts
public class oops {
    public static void main(String[] args) {
        System.out.println("COMPREHENSIVE OBJECT-ORIENTED PROGRAMMING DEMO");
        System.out.println("=" .repeat(60));
        
        // ========================== OBJECT CREATION ==========================
        System.out.println("\n1. CREATING OBJECTS (INSTANTIATION)");
        
        // Creating objects of different classes
        Dog myDog = new Dog("Buddy", 3, "Golden Retriever");
        Cat myCat = new Cat("Whiskers", 2, true);
        Bird myBird = new Bird("Tweety", 1, true);
        
        // Update animal count
        AnimalShelter.incrementAnimalCount();
        AnimalShelter.incrementAnimalCount();
        AnimalShelter.incrementAnimalCount();
        
        AnimalShelter.displayInfo();
        
        // ========================== ENCAPSULATION DEMO ==========================
        System.out.println("\n2. ENCAPSULATION (DATA HIDING & CONTROLLED ACCESS)");
        
        // Using getter methods to access private data
        System.out.println("Dog's name: " + myDog.getName());
        System.out.println("Dog's breed: " + myDog.getBreed());
        System.out.println("Dog's energy: " + myDog.getEnergy());
        System.out.println("Is dog hungry? " + myDog.isHungry());
        
        // Using setter methods to modify data in a controlled way
        myDog.setBreed("Labrador");
        System.out.println("Updated breed: " + myDog.getBreed());
        
        // ========================== INHERITANCE DEMO ==========================
        System.out.println("\n3. INHERITANCE (IS-A RELATIONSHIP)");
        
        // All these objects inherit from Animal class
        System.out.println("All animals can sleep (inherited method):");
        myDog.sleep();    // Inherited from Animal
        myCat.sleep();    // Inherited from Animal
        myBird.sleep();   // Inherited from Animal
        
        // ========================== POLYMORPHISM DEMO ==========================
        System.out.println("\n4. POLYMORPHISM (MANY FORMS)");
        
        // a) Runtime Polymorphism (Method Overriding)
        System.out.println("\na) Runtime Polymorphism - Same method, different behavior:");
        Animal[] animals = {myDog, myCat, myBird};
        AnimalShelter.makeAllAnimalsSound(animals); // Each animal makes different sound
        
        // b) Compile-time Polymorphism (Method Overloading)
        System.out.println("\nb) Compile-time Polymorphism - Method Overloading:");
        myDog.eat();              // eat() with no parameters
        myDog.eat("premium food"); // eat() with String parameter
        
        myBird.fly();    // fly() with no parameters
        myBird.fly(50);  // fly() with int parameter
        
        // c) Interface Polymorphism
        System.out.println("\nc) Interface Polymorphism:");
        Playable[] playableAnimals = {myDog, myCat};
        AnimalShelter.makePlayableAnimalsPlay(playableAnimals);
        
        // ========================== ABSTRACTION DEMO ==========================
        System.out.println("\n5. ABSTRACTION (HIDING IMPLEMENTATION DETAILS)");
        
        // Cannot create instance of abstract class
        // Animal animal = new Animal("Generic", 1); // This would cause error
        
        System.out.println("\nEach animal moves differently (abstract method implementation):");
        myDog.move();
        myCat.move();
        myBird.move();
        
        // ========================== INTERFACE DEMO ==========================
        System.out.println("\n6. INTERFACE IMPLEMENTATION");
        
        System.out.println("\nInterface methods and constants:");
        System.out.println("Max energy from interface: " + Playable.MAX_ENERGY);
        
        myDog.play();
        myDog.checkEnergy(); // Default method from interface
        myDog.rest();
        
        myCat.play();
        myCat.rest();
        
        // ========================== ADVANCED CONCEPTS DEMO ==========================
        System.out.println("\n7. ADVANCED OOP CONCEPTS");
        
        // Demonstrating that objects maintain their own state
        System.out.println("\nObject state management:");
        System.out.println("Dog energy before activities: " + myDog.getEnergy());
        myDog.play();
        myDog.move();
        System.out.println("Dog energy after activities: " + myDog.getEnergy());
        System.out.println("Is dog hungry? " + myDog.isHungry());
        
        myDog.eat();
        System.out.println("Dog energy after eating: " + myDog.getEnergy());
        System.out.println("Is dog hungry after eating? " + myDog.isHungry());
        
        // Cat-specific behavior
        System.out.println("\nCat-specific behavior:");
        myCat.climb(); // Method specific to Cat class
        
        // Bird-specific behavior
        System.out.println("\nBird-specific behavior:");
        System.out.println("Can this bird fly? " + myBird.canFly());
        myBird.fly(25);
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("OOP CONCEPTS DEMONSTRATED:");
        System.out.println("✓ Classes and Objects");
        System.out.println("✓ Encapsulation (private fields, getters/setters)");
        System.out.println("✓ Inheritance (extends keyword)");
        System.out.println("✓ Polymorphism (method overriding & overloading)");
        System.out.println("✓ Abstraction (abstract classes and methods)");
        System.out.println("✓ Interfaces and their implementation");
        System.out.println("✓ Static methods and variables");
        System.out.println("✓ Method overriding with @Override annotation");
        System.out.println("✓ Access modifiers (private, protected, public)");
        System.out.println("✓ Constructor chaining with super()");
        System.out.println("=" .repeat(60));
    }
}
