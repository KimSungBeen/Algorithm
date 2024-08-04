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

        HashMap<String, Integer> hm = new HashMap<>();

        for (String ownCardNumber : ownCardString.split(" ")) {
            Integer cnt = hm.getOrDefault(ownCardNumber, 0);
            hm.put(ownCardNumber, cnt + 1);
        }

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < comparerCards.length; i++) {
            sb.append(hm.getOrDefault(comparerCards[i], 0));


            if (i < comparerCards.length - 1) {
                sb.append(" ");
            }
        }

        System.out.print(sb);
    }
}