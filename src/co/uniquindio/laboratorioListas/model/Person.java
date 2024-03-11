package co.uniquindio.laboratorioListas.model;

public class Person {

    //Atributos de la clase Person
    String names;
    String lastName;
    String identification;

    //Constructor vacio de la clase Person
    public Person(){

    }

    //Constructor of Person class
    public Person(String nombres, String lastName, String cedula) {
        this.names = nombres;
        this.lastName = lastName;
        this.identification = cedula;
    }

    //getters() & setters() of Person class
    public String getNames() {
        return names;
    }
    public void setNames(String names) {
        this.names = names;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getIdentification() {
        return identification;
    }
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    //toString() of Person class
    @Override
    public String toString() {
        return "Person{" +
                "names='" + names + '\'' +
                ", lastNames='" + lastName + '\'' +
                ", identification='" + identification + '\'' +
                '}';
    }

    //-----------------------------------------------------------------------------------------------------------------
    //Necesary methods for Person managment
    
    //Method for knowing if the amount of digits in the identification is an even number
    public boolean isIdentificationEven(){
        return this.identification.length()%2==0;
    }
}
