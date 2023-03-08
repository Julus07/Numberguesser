import java.util.Scanner;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Numberguesser {
    int chosennumber, guess, trys;
    Scanner scanner;
    JFrame frame;
    JLabel label;
    JFormattedTextField field;

    public Numberguesser() {
        // gui();
        chosennumber = (int) Math.round(Math.random() * 100);
        refresh();
        input();
    }

    /*
    public void gui() {
        NumberFormat format = NumberFormat.getInstance();
        format.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setAllowsInvalid(false);

        frame = new JFrame("Numberguesser");
        frame.setSize(500, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel();
        label.setLocation(0, 0);
        label.setSize(500, 150);

        field = new JFormattedTextField(formatter);
        field.setLocation(0, 100);
        field.setSize(500, 50);

        frame.add(field);
        frame.add(label);
    }
     */

    public void input() {
        // label.setText("Bitte gib eine Zahl ein>> ");
        System.out.print("Bitte gib eine Zahl ein>> ");
        scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            guess = scanner.nextInt();
            trys++;
        }
        guessTester();
    }

    public void guessTester() {
        refresh();
        if (guess == chosennumber) {
            System.out.println("GEWONNEN!! Die gesuchte Zahl war: " + chosennumber);
            System.out.println("Du hast " + trys + " Versuche gebraucht");
            try {
                Thread.sleep(5000);
                new Numberguesser();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            if (guess > chosennumber)
                System.out.println("Deine Zahl ist zu groß!");
            if (guess < chosennumber)
                System.out.println("Deine Zahl ist zu klein!");
        }
        if (guess < 0 || guess > 100)
            System.out.println("Out of range!");
        input();
    }

    public void refresh() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        new Numberguesser();
    }
}