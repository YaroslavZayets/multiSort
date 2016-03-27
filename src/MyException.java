
public class MyException extends Exception {

    @Override
    public String getMessage(){
        return " Не больше 10 студентов в группе!  ";
    }

}
