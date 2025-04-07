package ladder.view;

import java.util.List;

public class OutputView {
    public void printNames(List<String> names) {
        System.out.println("실행결과");
        System.out.println();

        for (String name : names) {
            System.out.print(String.format("%5s ", name));
        }
        System.out.println();
    }

    public void printLadders(List<List<Boolean>> ladders) {
        for (List<Boolean> ladder : ladders) {
            System.out.print("    ");
            for (Boolean connected : ladder) {
                if (connected) {
                    System.out.print("|-----");
                } else {
                    System.out.print("|     ");
                }
            }
            System.out.println("|");
        }
    }
}
