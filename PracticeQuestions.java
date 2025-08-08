public class PracticeQuestions {

    // 1. Write a Java program to create a class called "Person" with a name and age attribute. Create two instances of the "Person" class, set their attributes using the constructor, and print their name and age.
    
    static class Person {
        private String name;
        private int age;

        public  Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    }

    // 2. Write a Java program to create a class called "Dog" with a name and breed attribute. Create two instances of the "Dog" class, set their attributes using the constructor and modify the attributes using the setter methods and print the updated values.

    static class Dog {
        private String name;
        private String breed;

        public Dog(String name, String breed) {
            this.name = name;
            this.breed = breed;
        }

        public String getName() {
            return name;
        }

        public String getBreed() {
            return breed;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setBreed(String breed) {
            this.breed = breed;
        }
    }
    // 3. Write a Java program to create a class called "Rectangle" with width and height attributes. Calculate the area and perimeter of the rectangle.

    static class Rectangle {

            double width;
            double height;

            public Rectangle(double width, double height) {
                this.width = width;
                this.height = height;
            }

            public double getArea() {
                return width * height;
            }

            public double getPerimeter() {
                return 2 * (width + height);
            }
    }    

    // 4. Write a Java program to create a class called "Circle" with a radius attribute. You can access and modify this attribute. Calculate the area and circumference of the circle.

    static class Circle {
        private double radius;

        public Circle (double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius( double radius) {
            this.radius = radius;
        }

        public double getArea() {
            return Math.PI * radius * radius;
        }

        public double getCircumference() {
            return 2 * Math.PI * radius;
        }

    }

    // 5. Write a Java program to create a class called "Book" with attributes for title, author, and ISBN, and methods to add and remove books from a collection.

    static class Book {
        String title;
        String author;
        String isbn;

        public Book(String title,String author,String isbn){
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }

        public void addBook(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }

        public void removeBook() {
            this.title = null;
            this.author = null;
            this.isbn = null;
        }
    }

    // 6. Write a Java program to create a class called "Employee" with a name, job title, and salary attributes, and methods to calculate and update salary.

    static class Employee {
        String name;
        String jobTitle;
        double salary;

        public Employee(String name, String jobTitle, double salary) {
            this.name = name;
            this.jobTitle = jobTitle;
            this.salary = salary;
        }

        public double raiseSalary(double percentage) {
            this.salary += this.salary * (percentage / 100);
            return this.salary;
        }

        public void employeeInfo() {
            System.out.println("Employee Name: " + name);
            System.out.println("Job Title: " + jobTitle);
            System.out.println("Salary: " + salary);
        }
    }
    

    public static void main(String[] args) {

        // 1. Write a Java program to create a class called "Person" with a name and age attribute. Create two instances of the "Person" class, set their attributes using the constructor, and print their name and age.

        Person person1 = new Person(" Muzna",19);
        Person person2 = new Person(" Eshal",16);

        System.out.println("Person 1 Name:  " + person1.getName()+ " Age: " + person1.getAge());
        System.out.println("Person 2 Name: " + person2.getName()+ " Age: " + person2.getAge());

        person1.setName("Rumaisa");
        person1.setAge(22);

        person2.setName("Zunair");
        person2.setAge(11);

        System.out.println("Updated Person 1 Name: " + person1.getName()+ " Age: " + person1.getAge());
        System.out.println("Updated Person 2 Name: " + person2.getName()+ " Age: " + person2.getAge());

        // 2. Write a Java program to create a class called "Dog" with a name and breed attribute. Create two instances of the "Dog" class, set their attributes using the constructor and modify the attributes using the setter methods and print the updated values.

        Dog dog1 = new Dog("Buddy", "Golden Retriever");
        Dog dog2 = new Dog("Max", "Beagle");

        System.out.println("Dog 1 Name: " + dog1.getName() + ", Breed: " + dog1.getBreed());
        System.out.println("Dog 2 Name: " + dog2.getName() + ", Breed: " + dog2.getBreed());

        dog1.setName("Charlie");
        dog1.setBreed("Labrador");
        System.out.println("Updated Dog 1 Name: " + dog1.getName() + ", Breed: " + dog1.getBreed());

        dog2.setName("Rocky");
        dog2.setBreed("Bulldog");
        System.out.println("Updated Dog 2 Name: " + dog2.getName() + ", Breed: " + dog2.getBreed());

        // 3. Write a Java program to create a class called "Rectangle" with width and height attributes. Calculate the area and perimeter of the rectangle.

        Rectangle rectangle1 = new Rectangle(5.0,3.0);
        System.out.println("Rectangle area: " + rectangle1.getArea());
        System.out.println("Rectangle perimeter: " + rectangle1.getPerimeter());

        // 4. Write a Java program to create a class called "Circle" with a radius attribute. You can access and modify this attribute. Calculate the area and circumference of the circle.

        Circle circle1 = new Circle(9.9);

        System.out.println("Circle radius: " + circle1.getRadius());
        System.out.println("Circle area: " + circle1.getArea());
        System.out.println("Circle circumference: " + circle1.getCircumference());

        circle1.setRadius(10.5);

        System.out.println("Updated Circle radius: " + circle1.getRadius());
        System.out.println("Updated Circle area: " + circle1.getArea());
        System.out.println("Updated Circle circumference: " + circle1.getCircumference());

        // 5. Write a Java program to create a class called "Book" with attributes for title, author, and ISBN, and methods to add and remove books from a collection.

        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
        System.out.println("Book Title: " + book1.title + ", Author: " + book1.author + ", ISBN: " + book1.isbn);
        book1.addBook("1984", "George Orwell", "9780451524935");
        System.out.println("Added Book Title: " + book1.title + ", Author: " + book1.author + ", ISBN: " + book1.isbn);
        book1.removeBook();
        System.out.println("Removed Book Title: " + book1.title + ", Author: " + book1.author + ", ISBN: " + book1.isbn);

        // 6. Write a Java program to create a class called "Employee" with a name, job title, and salary attributes, and methods to calculate and update salary.

        Employee employee1 = new Employee("Alice", "Software Engineer", 60000);
        employee1.employeeInfo();
        double newSalary = employee1.raiseSalary(18);
        System.out.println("Updated Salary after raise: " + newSalary);
        employee1.employeeInfo();

    }

}