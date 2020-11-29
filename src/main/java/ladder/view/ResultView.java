package ladder.view;

import ladder.domain.Line;
import ladder.domain.Lines;

import java.util.List;
import java.util.stream.IntStream;

import static ladder.view.ResultViewConfig.*;
import static ladder.domain.LadderConfig.*;

public class ResultView {

    private ResultView() {}

    public static void printGameResult(List<String> userNames, Lines lines) {
        System.out.print(RESULT_EXECUTE_MESSAGE);
        printGamePlayers(userNames);
        printLadderGame(lines);
    }

    private static void printGamePlayers(List<String> userNames) {
        userNames.forEach(name -> System.out.print(getPlayer(name) + " "));
        System.out.println();
    }

    private static String getPlayer(String name) {
        if(name.length() == MAX_NAME_LENGTH) {
            return name;
        }
        return String.format("%-"+MAX_NAME_LENGTH+"s",name);
    }

    private static void printLadderGame(Lines lines) {
        List<Line> lineList = lines.getLines();
        IntStream.range(0,lineList.size())
                .forEach(i -> printLine(lineList.get(i)));
    }

    private static void printLine(Line line) {
        List<Boolean> booleans = line.getPoints();
        System.out.print("    ");
        IntStream.range(0,booleans.size())
                .filter(i -> i != booleans.size())
                .forEach(i -> parseBooleanToString(line.hasRightMoved(i)));
        System.out.println();
    }

    private static void parseBooleanToString(boolean moved) {
        if(moved) {
            System.out.print("|-----");
            return;
        }
        System.out.print("|     ");
    }
}
