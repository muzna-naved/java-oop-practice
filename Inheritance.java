public class Inheritance {

    // Parent class 
    static class Animal {
        String name;
        String color;
        Animal(String name, String color) {
            this.name = name;
            this.color = color;
        }
        void sound() {
            System.out.println("Animal makes a sound");
        }
    }

    // Child class

    static class Dog extends Animal {
        Dog(String name,String color){
            super(name,color);
            this.name = name;
            this.color = color;
        }
        @Override
            void  sound() {
                System.out.println("Bow bow");
            }
    }

    public static void main(String[] args) {

        // Single Inheritance
        Animal animal1 = new Animal("Shark", "Blue");
        animal1.sound();
        Animal myDog = new Dog("Bruno","Black");
        myDog.sound();
        System.out.println("Animal name: " + animal1.name + "\t" + "Animal color: " + animal1.color);
        System.out.println("Dog name: " + myDog.name + "\t" + "Dog color: " + myDog.color);

        // Multilevel Inheritance

        Person person = new Person("Muzna");
        person.displayInfo();
        Employee employee = new Employee("Muzna", "Software Engineer");
        employee.displayInfo();
        Manager manager = new Manager("Muzna", "Software Engineer ", "IT Department");
        manager.displayInfo();
    }

    // Multilevel Inheritance

    // Base class 

    static class Person {
        String name;
        Person(String name) {
            this.name = name;
        }
        void displayInfo() {
            System.out.println("Person name: " + name);
        }
    }

    // Derived class

    static class Employee extends Person {
        String position;
        Employee(String name, String position) {
            super(name);
            this.position = position;
        }
        @Override
        void displayInfo() {
            System.out.println("Employee name: " + name);
            System.out.println("Position: " + position);
        }
    }

    // Further derived class

    static class Manager extends Employee {
        String department;
        Manager(String name, String position, String department) {
            super(name, position);
            this.department = department;
        }
        @Override
        void displayInfo() {
            System.out.println("Manager name: " + name);
            System.out.println("Position: " + position);
            System.out.println("Department: " + department);
        }
    }
}
