package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;

import java.util.stream.Collectors;

public class ResultView {
    public static void printLadder(Ladder ladder) {
        System.out.println(ladder.toStringResult());
    }
}
