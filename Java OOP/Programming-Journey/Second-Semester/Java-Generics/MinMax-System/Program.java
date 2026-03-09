package q1;
import java.util.*;

public class Program {

    public static int results(List<String> list, int hasima) {
        int max = 0;
        Map<String, Integer> count = new HashMap<>();

        for (String vote : list) {
            String party = vote.toLowerCase(); 
            count.put(party, count.getOrDefault(party, 0) + 1);
            max = Math.max(max, count.get(party));
        }
        System.out.println("Parties that did not pass hasima are:");
        boolean belowHasima = true;
        for (String party : count.keySet()) {
            if (count.get(party) < hasima) {
                System.out.println(party);
                belowHasima = false;
            }
        }
        if (belowHasima) {
            return 0;
        }
        System.out.println("Parties that did pass hasima are:");
        for (String party : count.keySet()) {
            if (count.get(party) >= hasima) {
                System.out.println(party + ":" + count.get(party));
            }
        }
        String maxParty = "";
        for (String party : count.keySet()) {
            if (count.get(party) == max) {
                maxParty = party;
                break;
            }
        }
        System.out.println("Biggest party is: " + maxParty);
            return max;
    }

    public static void main(String[] args) throws Exception {
        List<String> vots = Arrays.asList("BB","BB","Bb","aA","CCC","aa","cCc","aa","dddd","bb","bb");
        int x = results(vots, 2);

    }
}
