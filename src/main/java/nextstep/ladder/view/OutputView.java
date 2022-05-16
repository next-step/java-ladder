package nextstep.ladder.view;

import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.MaxHeightOfLadder;
import nextstep.ladder.domain.Members;
import nextstep.ladder.domain.RandomBooleanGenerator;

public class OutputView {
    public static void outputLadder(Members members, MaxHeightOfLadder maxHeightOfLadder) {
        System.out.println(members.getPrettyString());
        Lines lines = maxHeightOfLadder.getLines(members, new RandomBooleanGenerator());

        System.out.println(lines.getPoints());
    }
}
