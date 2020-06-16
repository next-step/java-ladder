package camp.nextstep.edu.nextstep8.ladder;

import camp.nextstep.edu.nextstep8.ladder.entity.Ladder;

public class LadderGameView {
    public static void show(Ladder ladder) {
        LadderViewGenerator view = new LadderViewGenerator(ladder);
        System.out.println(view.getHeaderForPrint());
        System.out.println(view.getLadderForPrint());
    }
}
