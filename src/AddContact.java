import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
Класс с методами для добавленяи контактов
 */
public class AddContact {
    protected static void newContact(){
        String text = "\nВведите имя и телефон через \"/\" \n 0 - для выхода в меню \n Новый контакт: ";
        Scanner iScaner = new Scanner(System.in);
        System.out.print(text);
        inputHandling(iScaner.nextLine());
    }

    protected static void inputHandling(String input){
        String errormes = "Не корректный ввод, просьба повторить.";

        if (input.equals("0")){
            Menu.menu();
        }

        String[] cutted = createArray(input);
        if (cutted.length != 2){
            System.out.println(errormes);
            newContact();
        }
        if (contactCheck(cutted[0])){
            List<String> tempL = PhoneBook.pb.get(cutted[0]);
            tempL.add(cutted[1]);
            PhoneBook.pb.put(cutted[0],tempL);
        }
        else {
            List<String> newL = new ArrayList<>();
            newL.add(cutted[1]);
            PhoneBook.pb.put(cutted[0],newL);
        }
        System.out.println("Контакт добавлен");
        Menu.menu();
    }

    protected static String[] createArray (String s){
        String[] newArray = s.trim().split("/");
        newArray[0] = newArray[0].trim();
        newArray[1] = newArray[1].trim();
        return newArray;
    }

    protected static boolean contactCheck(String contact){
        return PhoneBook.pb.containsKey(contact);
    }
}
