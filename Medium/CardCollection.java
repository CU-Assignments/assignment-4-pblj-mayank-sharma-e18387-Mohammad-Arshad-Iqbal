import java.util.*;

class Card {
    private String symbol;
    private String value;

    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return symbol + " " + value;
    }
}

public class CardCollection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, List<Card>> cardMap = new HashMap<>();

        System.out.print("Enter number of cards to add: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter card " + (i + 1) + " symbol: ");
            String symbol = sc.nextLine();
            System.out.print("Enter card " + (i + 1) + " value: ");
            String value = sc.nextLine();

            Card card = new Card(symbol, value);

            if (!cardMap.containsKey(symbol)) {
                cardMap.put(symbol, new ArrayList<>());
            }
            cardMap.get(symbol).add(card);
        }

        System.out.print("Enter symbol to search: ");
        String searchSymbol = sc.nextLine();

        Collection<Card> result = cardMap.getOrDefault(searchSymbol, new ArrayList<>());
        if (result.isEmpty()) {
            System.out.println("No cards found with symbol: " + searchSymbol);
        } else {
            System.out.println("Cards of symbol " + searchSymbol + ":");
            for (Card c : result) {
                System.out.println(c.getValue());
            }
        }
    }
}
