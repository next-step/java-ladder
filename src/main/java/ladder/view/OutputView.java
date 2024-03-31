package ladder.view;


import ladder.model.Ladder;
import ladder.model.Line;
import ladder.model.NameList;

import java.util.stream.Collectors;

public class OutputView {
    private static final String CONNECT = "-----";
    private static final String DISCONNECT = "     ";
    private static final String COLUMN = "|";

    public static void printLadderGameResult(NameList nameList, Ladder ladder) {
        printLadderGameResultTitle(nameList);

        for (Line line : ladder.getLines()) {
            String oneLine = line.getPoints().stream()
                    .map(point -> point ? CONNECT : DISCONNECT)
                    .collect(Collectors.joining(COLUMN, COLUMN, COLUMN));
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
