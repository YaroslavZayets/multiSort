
public class Student extends Man implements Comparable{

    private double rating;

    public Student(String name, String surname, int age ,double rating){
        super(name,surname,age);
        this.rating=rating;
    }

    @Override
    public int compareTo(Object o){
        if (o==null){
            return -1;
        }
        Student anotherStud = (Student) o;
        return this.getSurname().compareToIgnoreCase(anotherStud.getSurname());
    }



    public String getSurname(){
        return super.getSurname();
    }

    @Override
    public String toString(){
        return super.toString() + " , средняя оценка :  " + rating;
    }
}
