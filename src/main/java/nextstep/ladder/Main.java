package nextstep.ladder;

import nextstep.ladder.domain.ExecuteResults;
import nextstep.ladder.domain.InputOutput;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.People;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        People people = inputView.people();
        ExecuteResults executeResults = inputView.executeResults();
        InputOutput inputOutput = new InputOutput(people, executeResults);

        int verticalLineCount = people.value().size();
        int height = inputView.height();

        Ladder ladder = new Ladder(verticalLineCount, height);

        ResultView.printResult(inputOutput, ladder);

//        MatchResult matchResult = new MatchResult(ladder);

//        matchResult.result("pobi");

        inputView.close();
    }
}
