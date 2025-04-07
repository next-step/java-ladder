package nextstep.ladder.view;

import java.util.List;

import nextstep.Pair;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.ParticipantName;

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

    public void printResultAll(List<Pair<ParticipantName, String>> results) {
        for (Pair<ParticipantName, String> result : results) {
            System.out.println(result.getLeft().getValue() + " : " + result.getRight());
        }
        System.out.println();
    }

}
