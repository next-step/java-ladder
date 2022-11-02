package ladder;

import ladder.domain.ladder.LadderLineFactory;
import ladder.domain.person.name.SearchPeopleNames;
import ladder.domain.Result;
import ladder.domain.reward.Rewards;
import ladder.domain.ladder.size.LadderHeight;
import ladder.domain.ladder.size.LadderWidth;
import ladder.domain.person.People;
import ladder.domain.ladder.LadderLines;
import ladder.view.input.InputView;
import ladder.view.output.OutputView;


public class LadderController {

    private final LadderLineFactory ladderLineFactory;
    private final OutputView outputView;
    private final InputView inputView;

    public LadderController(OutputView outputView, InputView inputView) {
        this.ladderLineFactory = new LadderLineFactory();
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void gameStart() {
        People people = new People(inputView.personNameInput());

        Rewards rewards = new Rewards(inputView.splitResult());

        LadderLines ladderLines = ladderLineFactory.randomLadderLines(new LadderWidth(people.number()),
                new LadderHeight(inputView.ladderHeight()));

        outputView.ladderCreateResult(people, ladderLines, rewards);

        SearchPeopleNames searchPeopleNames = new SearchPeopleNames(inputView.inputResultPeopleNames());

        Result result = new Result(ladderLines, rewards, people.findAllBySearchPeopleNames(searchPeopleNames));

        outputView.gameResult(result);
    }
}
