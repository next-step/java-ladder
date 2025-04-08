package view;

import java.util.List;

public class OutputView {
    public static void printResultTitle() {
        System.out.println("\n실행결과\n");
    }

    public static void printParticipants(List<String> names) {
        for (String name : names) {
            System.out.printf("%-6s", name);
        }
        System.out.println();
    }
}