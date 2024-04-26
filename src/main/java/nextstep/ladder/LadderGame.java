package nextstep.ladder;

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
        Ladder ladder = new Ladder(countOfPeople).create(height, countOfPeople);
        OutputView.printRenderLines(ladder);

        LadderResult ladderResult = ladder.game();
        OutputView.printSplitOf(results);

        OutputView.printResult(people, results, ladderResult);
    }
}
