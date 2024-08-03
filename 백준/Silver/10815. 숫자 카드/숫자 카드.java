import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String ownCardCount = sc.nextLine();
        String ownCardString = sc.nextLine();
        String comparerCardCount = sc.nextLine();
        String comparerCardString = sc.nextLine();

        String[] comparerCards = comparerCardString.split(" ");

        HashMap<String, String> hm = new HashMap<>();

        for (String ownCardNumber : ownCardString.split(" ")) {
            hm.put(ownCardNumber, "1");
        }

        for (int i = 0; i < comparerCards.length; i++) {
            System.out.print(hm.getOrDefault(comparerCards[i], "0"));

            if (i < comparerCards.length - 1) {
                System.out.print(" ");
            }
        }
    }
}