package camp.nextstep.edu.nextstep8.ladder;

import camp.nextstep.edu.nextstep8.ladder.entity.Ladder;

public class LadderGameView {
    public static void show(Ladder ladder) {
        System.out.println(ladder.getHeaderPrintString());
        System.out.println(ladder.getLadderPrintString());
    }
}
