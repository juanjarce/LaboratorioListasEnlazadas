package co.uniquindio.laboratorioListas.model;

public class People implements Comparable<People> {

    //Atributos de la clase People
    String names;
    String lastName;
    String identification;

    //Constructor vacio de la clase People
    public People(){

    }

    //Constructor of People class
    public People(String nombres, String lastName, String cedula) {
        this.names = nombres;
        this.lastName = lastName;
        this.identification = cedula;
    }

    //getters() & setters() of People class
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

    //toString() of People class
    @Override
    public String toString() {
        return "People{" +
                "names='" + names + '\'' +
                ", lastNames='" + lastName + '\'' +
                ", identification='" + identification + '\'' +
                '}';
    }

    //-----------------------------------------------------------------------------------------------------------------
    //Necesary methods for People managment
    
    //Method for knowing if the amount of digits in the identification is an even number
    public boolean isIdentificationEven(){
        return this.identification.length()%2==0;
    }

    @Override
    public int compareTo(People o) {
        return identification.compareTo(o.identification);
    }
}
