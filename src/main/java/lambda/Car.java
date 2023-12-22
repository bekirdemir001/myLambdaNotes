package lambda;

public class Car {

    /*
    POJO: Plain Old Java Object
        1)Constructor without a parameter
        2)Constructor with all parameters
        3)getter() and setter()
        4)toString
     */

    String make;
    String model;
    int year;
    int km;
    String fuelType;

    //1)Constructor without a parameter
    public Car() {
    }

    //2)Constructor with all parameters
    public Car(String make, String model, int year, int km, String fuelType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.km = km;
        this.fuelType = fuelType;
    }

    //3)getter() and setter()
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    //4)toString
    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", km=" + km +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }

}