package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderCreator;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args) {
        List<String> people = InputView.getPeople();
        Ladder ladder = LadderCreator.create(people.size(), InputView.getHeight());

        ladder.play();

        ResultView.printResult(people, ladder);
    }
}
