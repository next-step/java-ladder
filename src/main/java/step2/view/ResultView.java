package step2.view;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final int MAX_NAME_LENGTH = 5;

    public static void printUserName(List<String> nameList) {
        String userName = nameList
                .stream()
                .map(name -> addBlank(name))
                .collect(Collectors.joining());

        System.out.println(userName);
    }

    public static String addBlank(String name) {
        int blankCount = MAX_NAME_LENGTH - name.length();

        if (blankCount == 0) {
            return " " + name;
        }

        if (blankCount == 1) {
            return name + " ";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < blankCount; i++) {
            sb.append(" ");
        }
        return sb.toString() + name;
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
