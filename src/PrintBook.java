import java.util.*;

/*
Ввывод тел книги в консоль
*/
public class PrintBook {
    protected static void printBook() {

        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(PhoneBook.pb.entrySet());

        // подсмотрел этот кусок
        Collections.sort(entries, new Comparator<Map.Entry<String, List<String>>>() {
            @Override
            public int compare(Map.Entry<String, List<String>> e1, Map.Entry<String, List<String>> e2) {
                return Integer.compare(e2.getValue().size(), e1.getValue().size());
            }
        });

        for (int i = 0; i < entries.size(); i++) {
            System.out.println(entries.get(i));
        }

        Menu.menu();
    }
}
