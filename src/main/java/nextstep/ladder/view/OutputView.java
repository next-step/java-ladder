package nextstep.ladder.view;

import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.MaxHeightOfLadder;
import nextstep.ladder.domain.Members;
import nextstep.ladder.domain.RandomBooleanGenerator;
import nextstep.ladder.domain.RunResults;

public class OutputView {
    private static final RandomBooleanGenerator RANDOM_BOOLEAN_GENERATOR;

    static {
        RANDOM_BOOLEAN_GENERATOR = new RandomBooleanGenerator();
    }

    public static void outputLadder(Members members, MaxHeightOfLadder maxHeightOfLadder, RunResults runResults) {
        System.out.println(members.getPrettyString());
        Lines lines = maxHeightOfLadder.getLines(members, RANDOM_BOOLEAN_GENERATOR);

        System.out.println(lines.getPoints());
        System.out.println(runResults);
    }
}
