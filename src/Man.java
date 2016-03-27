
public class Man {
    private String name;
    private String surname;
    private int age;

    public Man (String name, String surname, int age){
        this.name=name;
        this.surname = surname;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public String toString(){
        return "Имя " + name + " , фамилия " + surname + " , возраст " + age;
    }
}
