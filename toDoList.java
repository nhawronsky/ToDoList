import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class toDoList {
    public static void main(String[] args) {
        toDoRunner();
    }


    static void toDoRunner() {
        int ProgramStart = 0, choose;
        MyList l = new MyList();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                if (ProgramStart == 0)
                    System.out.println("Do you want to start a program? Yes = 1, No = 2");
                else
                    System.out.println("Resume? Yes = 1, No = 2");
                System.out.print("Put option: ");
                choose = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("----------\n" + "Your choice is incorrect!");
                continue;
            }
            System.out.println("----------");
            switch (choose) {
                case 1 -> {
                    int t;
                    try {
                        l.toDo();
                        System.out.println("----------");
                        System.out.print("Put option: ");
                        t = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("your command isn't included");
                        continue;
                    }
                    System.out.println();
                    l.setTask(t);
                    l.work();
                    System.out.println("----------\n");
                    ProgramStart++;
                }
                case 2 -> System.out.println("Thank you!");
            }
            System.out.println();
            if (choose == 2) {
                break;
            }
        }
    }
}

class MyList{
    int task, sumOfElem = 0;
    List<String> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    void setTask(int task){ this.task = task;}
    int getTask(){return task;}

    void work(){
        switch (getTask()) {
            case 1 -> taskAdd();
            case 2 -> taskRemove();
            case 3 -> taskShowList();
            case 4 -> clearAll();
            case 5 -> sizeInTheList();
        }
    }
    void sizeInTheList(){
        System.out.println("num of elements in your list is: " + list.size());
    }
    void clearAll(){
        list.clear();
        System.out.println("Your list is clear");
    }
    void taskAdd(){
        sumOfElem++;
        System.out.println("Put your task " + sumOfElem + ": ");
        String addOption = sc.nextLine();
        list.add(addOption);
    }
    void taskRemove(){
        System.out.println("Your list:");
        showList();
        System.out.println("Remove elem: ");
        sumOfElem--;
        int removeElem = 0;
        try{
        removeElem = sc.nextInt();}
        catch (InputMismatchException e){
            System.out.println("this symbol isn't exist");
        }
        removeElem--;
        try{
        list.remove(removeElem);
        } catch (IndexOutOfBoundsException e){
            System.out.println("In list are no element with number: " + ++removeElem);
        }
    }
    void taskShowList(){
        System.out.println("Show list:");
        showList();
    }

    void showList(){
        int elements = 1;
        for(String show : list){
            System.out.println( elements + ": " + show);
            elements++;
        }
    }

    void toDo(){
        System.out.println("1. add element");
        System.out.println("2. remove");
        System.out.println("3. view tasks");
        System.out.println("4. clear list");
        System.out.println("5. how many elements are in the list");
    }
}
