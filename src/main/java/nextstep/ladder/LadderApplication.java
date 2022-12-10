package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderCreator;
import nextstep.ladder.domain.LadderResults;
import nextstep.ladder.domain.ResultProcessor;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args) {
        List<String> people = InputView.getPeople();
        List<String> result = InputView.getPlayResults();
        int sizeOfPerson = people.size();

        Ladder ladder = LadderCreator.create(sizeOfPerson, InputView.getHeight());
        ResultProcessor resultProcessor = new ResultProcessor(people, result);
        LadderResults ladderResults = resultProcessor.toResult(ladder.play(sizeOfPerson));

        ResultView.printResult(people, ladder, result);
        while (true) {
            String name = InputView.getName();
            ResultView.printLadderResult(ladderResults, name);

            if ("all".equals(name)) {
                break;
            }
        }
    }
}
