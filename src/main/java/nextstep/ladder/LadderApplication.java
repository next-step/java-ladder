package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderCreator;
import nextstep.ladder.domain.LadderResults;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args) {
        List<String> people = InputView.getPeople();
        List<String> playResults = InputView.getPlayResults();
        Ladder ladder = LadderCreator.create(people, InputView.getHeight(), playResults);

        LadderResults ladderResults = ladder.play();

        ResultView.printResult(people, ladder, playResults);
        while (true) {
            String name = InputView.getName();
            ResultView.printLadderResult(ladderResults, name);

            if ("all".equals(name)) {
                break;
            }
        }
    }
}
