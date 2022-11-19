package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderCreator;
import nextstep.ladder.domain.LineCreator;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args) {
        List<String> people = InputView.getPeople();
        LadderCreator ladderCreator = new LadderCreator(new LineCreator());
        Ladder ladder = ladderCreator.create(people.size(), InputView.getHeight());

        ladder.play();

        ResultView.printResult(people, ladder);
    }
}
