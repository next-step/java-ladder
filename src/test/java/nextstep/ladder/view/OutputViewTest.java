package nextstep.ladder.view;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.RandomTrueOrFalse;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    @Test
    void print_ladder() {
        Ladder ladder = new Ladder(10, 5, new RandomTrueOrFalse());
        OutputView outputView = new OutputView();
        outputView.printLadder(ladder);

    }

}