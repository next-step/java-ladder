package step2.view;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printUserName(List<String> userName) {
        String name = userName.stream()
                .collect(Collectors.joining());

        System.out.println(name);
    }
    public static void printLadder(List<List<Boolean>> ladder) {
        for (List<Boolean> line : ladder) {
            printLine(line);
            System.out.println();
        }
    }

    private static void printLine(List<Boolean> line) {
        for (int i = 0; i < line.size(); i++){
            System.out.print(checkLine(line, i));
        }
    }

    private static String checkLine(List<Boolean> line, int i) {
        if (i == 0) {
            return "    |";
        }

        if (line.get(i)) {
            return "-----|";
        }

        return "     |";
    }
}
