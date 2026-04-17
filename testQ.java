import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class testQ {
    public static void main(String[] args) {
        MindBend m = new MindBend();
        String s0 = m.getSourceCode();
        String s1 = m.printSelf();
        String s2 = m.printSelfMirror();

        // ---------------------------------------------------------
        // TEST 1: Source Code vs Generated PrintSelf
        // ---------------------------------------------------------
        Scanner sc0 = new Scanner(s0);
        Scanner sc1 = new Scanner(s1);
        boolean test1Pass = true;
        int line = 1;

        while (sc0.hasNextLine() && sc1.hasNextLine()) {
            String l0 = sc0.nextLine();
            String l1 = sc1.nextLine();
            if (!l0.equals(l1)) {
                System.out.println("Test 1 Failed at line " + line + ":");
                System.out.println("Source: [" + l0 + "]");
                System.out.println("Quine : [" + l1 + "]");
                test1Pass = false;
                break;
            }
            line++;
        }
        if (test1Pass) System.out.println("woot (Test 1 Passed!)");
        sc0.close();
        sc1.close();

        // ---------------------------------------------------------
        // TEST 2: PrintSelf vs Reversed PrintSelfMirror
        // ---------------------------------------------------------
        Scanner sc2 = new Scanner(s2);
        List<String> rev = new ArrayList<>();
        // hasNextLine() preserves the blank lines. hasNext() skips them!
        while (sc2.hasNextLine()) {
            rev.add(sc2.nextLine());
        }
        sc2.close();
        
        Collections.reverse(rev);
        
        Scanner sc1_again = new Scanner(s1);
        boolean test2Pass = true;
        line = 1;

        for (String reversedLine : rev) {
            if (!sc1_again.hasNextLine()) break;
            String fwdLine = sc1_again.nextLine();
            
            if (!fwdLine.equals(reversedLine)) {
                System.out.println("Test 2 Failed at line " + line + ":");
                System.out.println("Quine : [" + fwdLine + "]");
                System.out.println("Mirror: [" + reversedLine + "]");
                test2Pass = false;
                break;
            }
            line++;
        }
        if (test2Pass) System.out.println("woot woot!! (Test 2 Passed!)");
        sc1_again.close();
    }
}