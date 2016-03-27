import javax.swing.*;
import java.util.Arrays;

public class Group {
    private Student[] students = new Student[10];
    int n = 0;


    public  void addStudents(Student stud)
    {

        try {
            students[n++]=stud;
            if (n>10){
                throw new MyException();
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException r){
            System.out.println("Не больше 10 студентов в группе! ");
        }
    }

    public void searchStudent()  {
        String surname;
        surname = String.valueOf(JOptionPane.showInputDialog("Введите фамилию"));

        boolean isFound = false;
        for (int i = 0; i<students.length; i++){
            if (students[i]!=null){
                if (students[i].getSurname().equals(surname)){
                    isFound = true;
                    JOptionPane.showMessageDialog(null, students[i].toString());
                    break;
                }
            }
        }
        if (!isFound) JOptionPane.showMessageDialog(null, " Не найдено такого студента ");
    }


    public void showInfo(){
        for (int i = 0; i<students.length; i++){
            if (students[i]!=null){
                System.out.println(students[i].toString());
            } else
                System.out.println(" Ячейка " + (i+1) + " пуста");
        }
    }



    public void addNow () {
        int count = Integer.valueOf(JOptionPane.showInputDialog("Введите количество студентов в группе "));

        for (int i = 0; i<count; i++){
            try {
                Student ST = new Student(String.valueOf(JOptionPane.showInputDialog("Введите имя " + (i+1) + "ого студента")),
                        String.valueOf(JOptionPane.showInputDialog("Введите фамилию " + (i+1) + "ого студента")),
                        Integer.valueOf(JOptionPane.showInputDialog("Введите возвраст "+ (i+1) + "ого студента")),
                        Double.valueOf(JOptionPane.showInputDialog("Введите оценку "+ (i+1) + "ого студента")));
                students[n++]=ST;
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null," Не верный формат! ");
            }catch (ArrayIndexOutOfBoundsException r) {
                System.out.println("Не больше 10 студентов в группе! ");
            }
        }

    }

    public void sortBySurname(){

        try {
            Arrays.sort(students);

        } catch (NullPointerException e){
            System.out.println(" Неполная группа студентов! ");
        } finally {
            for (int i = 0; i<students.length; i++) {
                if (students[i]!=null){
                    System.out.println(students[i].toString());
                }

            }

        }

    }

}
