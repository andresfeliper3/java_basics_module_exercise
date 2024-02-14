import org.university.menu.Menu;

public class Main {
    public static void main(String[] args) {
        try {
            Menu menu = new Menu();
            menu.startMenu();
        }
        catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}