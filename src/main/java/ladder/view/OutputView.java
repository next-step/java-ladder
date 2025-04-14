package ladder.view;

import java.util.List;
import ladder.model.LadderLine;
import ladder.model.LadderSession;

public class OutputView {

    public static void printLadderSession(LadderSession ladderSession){
        System.out.println("ladderSession = " + ladderSession);

        System.out.println("실행결과\n");

        printSlots(ladderSession.getUserNames());
        printLadder(ladderSession);
        printSlots(ladderSession.getResultNames());
    }

    private static void printSlots(List<String> slotStrs) {
        slotStrs
            .stream()
            .map(word -> String.format("%5s", word))
            .forEach(name -> System.out.print(name + " "));
        System.out.println();
    }

    private static void printLadder(LadderSession ladderSession) {
        ladderSession.getLadderLines()
            .forEach(OutputView::printLadderLine);
    }

    private static void printLadderLine(LadderLine line) {
        StringBuilder sb = new StringBuilder("     |");
        line.crosses().forEach(cross -> sb.append(cross ? "-----|" : "     |"));
        System.out.println(sb);
    }
}
