public class ClassesAndObjects {

    // This class represents a Student with a name and roll number.
    static class Student {
        String name;
        int rollNo;
        public Student(String name, int rollNo) {
            this.name = name;
            this.rollNo = rollNo;
        }
        public  void display() {
            System.out.println("Name: " + name + ", Roll No: " + rollNo);
        }
    }

     // This class represents a Car with speed and model and a method to accelerate.

    static class Car {
        int speed;
        String model;
        public Car(int speed, String model) {
            this.speed = speed;
            this.model = model;
        }

        public void accelerate() {
            System.out.println("The car is accelerating.");
        }
    }

    public static void main(String[] args) {

        // Objecct of Student class 

        Student S1 = new Student("Muzna",19);
        S1.display();

        // Object of Car class

        Car car1 = new Car(120, "Toyota");
        System.out.println("Car Model: " + car1.model + ", Speed: " + car1.speed);
        car1.accelerate();
    }
}
