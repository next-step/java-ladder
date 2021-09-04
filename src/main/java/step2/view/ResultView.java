package step2.view;

import java.util.*;
import java.util.stream.Collectors;

public class ResultView {
    private static final int MAX_NAME_LENGTH = 5;

    public static void printResult(List<String> resultList) {
        String results = resultList
                .stream()
                .map(ResultView::addBlank)
                .collect(Collectors.joining());

        System.out.println(results);
    }

    public static String addBlank(String name) {
        int blankCount = MAX_NAME_LENGTH - name.length();

        if (blankCount == 1) {
            return name + " ";
        }

        StringBuilder blank = new StringBuilder();
        for (int i = 0; i < blankCount; i++) {
            blank.append(" ");
        }
        return blank + name + " ";
    }

    public static void printLadder(List<List<Boolean>> ladder) {
        for (List<Boolean> line : ladder) {
            printLine(line);
            System.out.println();
        }
    }

    private static void printLine(List<Boolean> line) {
        for (int i = 0; i < line.size()-1; i++){
            System.out.print(checkLine(line, i));
        }
    }

    private static String checkLine(List<Boolean> line, int i) {
        String result = "";

        if (i == 0) {
            result += "    |";
        }

        if (line.get(i)) {
            return result + "-----|";
        }

        return result + "     |";
    }

    public static void printUserResult(String userName, LinkedHashMap<String, String> gameResult) {
        if (userName.trim().equals("all")) {
            printAllResult(gameResult);
            return;
        }

        if (!gameResult.containsKey(userName)) {
            throw new IllegalArgumentException("참여하지 않은 참가자 입니다. 다시 확인해주세요");
        }

        System.out.println(gameResult.get(userName));
    }

    private static void printAllResult(LinkedHashMap<String, String> gameResult) {
        gameResult.forEach((key, value) -> {
            System.out.println(key + " : " +value);
        });
    }
}
