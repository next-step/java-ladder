package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.Line;
import ladder.dto.ResultDto;

import java.util.List;

public class OutputView {
    private static final String MSG_LADDER = "사다리 결과";
    private static final String MSG_RESULT = "실행 결과";
    private static final String MSG_FORMAT_NAME = "%5s ";
    private static final String LINE_START = "  ";
    private static final String LINE_TRUE = "|-----";
    private static final String LINE_FALSE = "|     ";
    private static final String LINE_END = "|";
    private static final String ALL = "all";

    public void printLadder(Ladder ladder, LadderResult ladderResult) {
        System.out.println(MSG_LADDER);

        ladderResult.getPlayers().forEach(name -> System.out.printf(MSG_FORMAT_NAME, name));
        System.out.println();

        ladder.getLines().forEach(this::printLine);

        ladderResult.getResults().forEach(name -> System.out.printf(MSG_FORMAT_NAME, name));
        System.out.println();
    }

    private void printLine(Line line) {
        System.out.print(LINE_START);
        for (int i = 0; i < line.size(); i++) {
            if (line.point(i)) {
                System.out.print(LINE_TRUE);
                continue;
            }
            System.out.print(LINE_FALSE);
        }
        System.out.println(LINE_END);
    }

    public void printResult(Ladder ladder, LadderResult ladderResult, String name) {
        System.out.println(MSG_RESULT);
        if (name.equals(ALL)) {
            printAllResult(ladder, ladderResult);
            return;
        }
        System.out.println(ladderResult.matchedResult(name, ladder));
    }

    private void printAllResult(Ladder ladder, LadderResult ladderResult) {
        List<ResultDto> results = ladderResult.matchedAllResult(ladder);
        results.forEach(i -> System.out.println(i.getPlayer() + " : " + i.getResult()));
    }
}
