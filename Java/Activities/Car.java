package activities;

public class Car {
    String color = new String();
    String transmission = new String();
    int make;
    int tyres;
    int doors;

    Car(){
        tyres = 4;
        doors = 4;
    }
    void displayCharacteristics(){
       System.out.println("Color of the car is: "+color);
       System.out.println("Transmission of the car is: "+transmission);
       System.out.println("Make of the car is: "+make);
       System.out.println("No. of the tyres are: "+tyres);
       System.out.println("No. of the doors are: "+doors);
    }
    void accelerate(){
        System.out.println("Car is moving forward.");
    }
    void brake(){
        System.out.println("Car has stopped.");
    }
}
