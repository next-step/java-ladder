package ladder.controller;

import ladder.domain.RandomDraw;
import ladder.domain.Winning;
import ladder.dto.InputManagement;
import ladder.domain.Ladder;
import ladder.dto.Name;
import ladder.dto.Results;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderController {

    private final InputView inputView;
    private final ResultView resultView;

    public LadderController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        List<String> names = inputView.names();
        Results results = new Results(inputView.results());
        InputManagement inputManagement = new InputManagement(names, inputView.height());

        Ladder ladder = new Ladder(inputManagement.getNames().size(), inputManagement.getHeight());
        ladder.drawLine(new RandomDraw());

        Winning winning = new Winning();
        int startIndex = 0;
        for (Name name : inputManagement.getNames()) {
            int resultIndex = ladder.result(startIndex++);
            winning.record(name, results.getResults().get(resultIndex));
        }

        resultView.print(inputManagement.getNames(), ladder.getLadder());
        resultView.printResultList(results);

        int isRemainTurn = inputManagement.getNames().size();
        String person = "";
        do {
            person = inputView.person();
            resultView.printResult(winning, person);
        } while (--isRemainTurn > 0 && !person.equals("all"));
    }
}
