package nextstep.ladder.view;

import nextstep.ladder.domain.LadderNames;

public class ResultView {
    public static void printName(LadderNames ladderNames) {
        ladderNames.getLadderNames().forEach(System.out::print);
    }

}
