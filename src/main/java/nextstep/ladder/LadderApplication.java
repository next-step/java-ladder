package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderCreator;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args) {
        List<String> people = InputView.getPeople();
        List<String> playResults = InputView.getPlayResults();
        Ladder ladder = LadderCreator.create(people, InputView.getHeight());

        List<LadderResult> results = ladder.play();

        ResultView.printResult(people, ladder, playResults);
    }
}
