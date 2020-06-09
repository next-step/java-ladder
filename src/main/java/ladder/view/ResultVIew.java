package ladder.view;

import ladder.domain.Line;

import java.util.List;

public class ResultVIew {
    private static final String PLAY_RESULT = "사다리 결과\n";
    private static final int NAME_SPACE = 6;
    private static final String LINES = "-----";
    private static final String EMPTY_LINES = "     ";
    private static StringBuilder stringBuilder;

    public static void printLadder(List<String> peopleNames, List<Line> lineList) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(PLAY_RESULT);

        peopleNames.forEach(ResultVIew::printName);
        stringBuilder.append("\n");

        lineList.forEach(line -> printLine(line.getPoints()));
        stringBuilder.replace(stringBuilder.length()-1, stringBuilder.length(), "");
        System.out.println(stringBuilder.toString());
    }

    public static void printResults(List<String> results) {
        stringBuilder = new StringBuilder();
        results.forEach(ResultVIew::printName);
        System.out.println(stringBuilder.toString());
    }

    private static void printName(String name) {
        for (int idx = 0; idx < NAME_SPACE - name.length(); idx++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(name);
    }

    private static void printLine(List<Boolean> points) {
        points.forEach(v -> {
            if (v) {
                stringBuilder.append(LINES);
            } else {
                stringBuilder.append(EMPTY_LINES);
            }
            stringBuilder.append("|");
        });
        stringBuilder.append("\n");
    }
}
