package nextstep.ladder.view;

import java.util.List;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResult;

public class ResultView {

    public void printLadder(Ladder ladder) {
        System.out.println("실행결과");
        System.out.println();
        System.out.println(LadderFormatter.format(ladder));
        System.out.println();
    }

    public void printResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
        System.out.println();
    }

    public void printResultAll(List<LadderResult> results) {
        for (LadderResult result : results) {
            System.out.println(result.getName().getValue() + " : " + result.getResult());
        }
        System.out.println();
    }

}
