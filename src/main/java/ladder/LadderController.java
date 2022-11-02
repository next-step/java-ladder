package ladder;

import ladder.domain.ladder.ladderline.LadderLineFactory;
import ladder.domain.ladder.strategy.LadderConnectType;
import ladder.domain.person.SearchPeopleNames;
import ladder.domain.Result;
import ladder.domain.Rewards;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.LadderWidth;
import ladder.domain.person.People;
import ladder.domain.ladder.ladderline.LadderLines;
import ladder.view.InputView;
import ladder.view.output.OutputView;


public class LadderController {

    private final LadderLineFactory ladderLineFactory;
    private final OutputView outputView;


    public LadderController(LadderConnectType ladderConnectStrategy, OutputView outputView) {
        this.ladderLineFactory = new LadderLineFactory(ladderConnectStrategy);
        this.outputView = outputView;
    }

    public void gameStart() {
        People people = new People(InputView.personNameInput());

        Rewards rewards = new Rewards(InputView.splitResult());

        LadderLines ladderLines = ladderLineFactory.randomLadderLines(new LadderWidth(people.number()),
                new LadderHeight(InputView.ladderHeight()));

        outputView.ladderCreateResult(people, ladderLines, rewards);

        SearchPeopleNames searchPeopleNames = new SearchPeopleNames(InputView.inputResultPeopleNames());

        Result result = new Result(ladderLines, rewards, people.findByName(searchPeopleNames));

        outputView.gameResult(result);
    }
}
