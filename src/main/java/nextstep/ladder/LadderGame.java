package nextstep.ladder;

import nextstep.ladder.domain.rdd.GameLadderCreator;
import nextstep.ladder.domain.rdd.GameLineCreator;
import nextstep.ladder.interfaces.Ladder;
import nextstep.ladder.interfaces.LadderResult;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class LadderGame {

    public static void main(String[] args) {
        List<String> people = InputView.nextPeople();
        List<String> results = InputView.nextResult();
        int height = InputView.nextHeight();
        InputView.nextLine();

        OutputView.printLadderResultString();
        OutputView.printSplitOf(people);

        int countOfPeople = people.size();
        GameLineCreator lineCreator = new GameLineCreator();
        GameLadderCreator ladderCreator = new GameLadderCreator(lineCreator);
        Ladder ladder = ladderCreator.create(height, countOfPeople);
        OutputView.printRenderLines(ladder);

        LadderResult ladderResult = ladder.game();
        OutputView.printSplitOf(results);

        OutputView.printResult(people, results, ladderResult);
    }
}
