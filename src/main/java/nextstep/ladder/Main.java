package nextstep.ladder;

import nextstep.ladder.domain.*;
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

        ResultView.printLadder(inputOutput, ladder);

        Match match = new Match(inputOutput, ladder);
        Result result = match.makeResult();
        String person = inputView.person();

        ResultView.printResult(result, person);

        inputView.close();
    }
}
