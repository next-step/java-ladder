package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderRecord;

import java.util.List;

public class ResultView {


    public static void printLadder(LadderRecord ladderRecord, Ladder ladder) {
        System.out.println("사다리결과");
        System.out.println(ladderRecord.getUserFormat());

        List<String> ladderFormat = ladder.drawLadder();
        ladderFormat.forEach(System.out::println);

        System.out.println(ladderRecord.getOutcomeFormat());

    }

    public static void printResult(List<String> outcome) {
        System.out.println("실행 결과");
        outcome.forEach(System.out::println);
    }
}
