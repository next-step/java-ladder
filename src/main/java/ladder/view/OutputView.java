package ladder.view;


import ladder.Ladder;
import ladder.Line;
import ladder.NameList;

import java.util.stream.Collectors;

public class OutputView {
    private static final String CONNECT = "-----";
    private static final String DISCONNECT = "     ";
    private static final String COLUMN = "|";
    private static final String NEW_LINE = "\n";


    public static void printLadderGameResult(NameList nameList, Ladder ladder) {
        printLadderGameResultTitle(nameList);

        for (Line line : ladder.getLines()) {
            String oneLine = line.getPoints().stream()
                    .map(point -> point ? CONNECT : DISCONNECT)
                    .collect(Collectors.joining(COLUMN, COLUMN, COLUMN + NEW_LINE));
            System.out.println(oneLine);
        }

    }


    private static void printLadderGameResultTitle(NameList nameList) {
        System.out.println("실행 결과");

        for (String name : nameList.getNameList()) {
            System.out.print(String.format("%-6s", name));
        }
        System.out.println();

    }

}
