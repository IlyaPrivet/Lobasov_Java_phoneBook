import java.util.Scanner;

public class Menu {
    /*
    главное меню с активацией опций
    в начале спрашивает действие пользователя,
    потом переходим в функцию под выбранное действие
     */
    protected static void menu (){
        int i = scaner_menu();
        if (i == 0) Exit.exit();
        if (i == 1) AddContact.newContact();
        if (i == 2) PrintBook.printBook();
    }


    /*
    запрос действия у пользователя, возвращаем int
    */
    protected static int scaner_menu (){
        String textmenu = "Просьба выбрать:\n 1 - добавить контакт \n 2 - показать тел книгу \n 0 - выйти \n ваш выбор: ";
        String texterror = "Ошибка ввода, попробуйте еще раз";

        Scanner iScaner = new Scanner(System.in);
        System.out.print(textmenu);
        // можно ли данную проверку, что введено именно число 0-3 уложить в 1 строчку?
        if (!iScaner.hasNextInt()){
            System.out.println(texterror);
            scaner_menu();
        }
        int option = iScaner.nextInt();
        if (option < 0  || option > 2){
            System.out.println(texterror);
            scaner_menu();
        }
        return option;
    }
}
