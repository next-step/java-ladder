package ladder.view;

import ladder.domain.Line;

import java.util.List;

public class ResultVIew {
    private static final String PLAY_RESULT = "실행결과\n\n";
    private static final int NAME_SPACE = 6;
    private static final String LINES = "-----";
    private static final String EMPTY_LINES = "     ";
    private static StringBuilder stringBuilder;

    public static void printLadder(List<String> peopleNames, List<Line> lineList) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(PLAY_RESULT);

        peopleNames.forEach(name -> printName(stringBuilder, name));
        stringBuilder.append("\n");

        lineList.forEach(line -> printLine(stringBuilder, line.getPoints()));
        System.out.println(stringBuilder.toString());
    }

    private static void printName(StringBuilder stringBuilder, String name) {
        for (int idx = 0; idx < NAME_SPACE - name.length(); idx++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append(name);
    }

    private static void printLine(StringBuilder stringBuilder, List<Boolean> points) {
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
