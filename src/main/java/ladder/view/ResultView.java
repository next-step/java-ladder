package ladder.view;

import ladder.domain.Ladder;

import java.util.List;

public class ResultView {


    public static void printLadder(Ladder ladder) {
        System.out.println("실행결과");
        System.out.println(ladder.getUserFormat());

        List<String> ladderFormat = ladder.drawLadder();
        ladderFormat.forEach(System.out::println);

        System.out.println(ladder.getOutcomeFormat());
    }
}
