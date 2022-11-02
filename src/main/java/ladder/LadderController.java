package ladder;

import ladder.domain.ladder.ladderline.LadderLineFactory;
import ladder.domain.ladder.strategy.LadderConnectStrategy;
import ladder.domain.person.Person;
import ladder.domain.person.SearchPeopleNames;
import ladder.domain.Result;
import ladder.domain.Rewards;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.LadderWidth;
import ladder.domain.person.People;
import ladder.domain.ladder.ladderline.LadderLines;
import ladder.dto.LadderGameResultDto;
import ladder.service.LadderGameResultService;
import ladder.util.LadderOutputConverter;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderController {

    private final LadderGameResultService ladderGameResultService;
    private final LadderLineFactory ladderLineFactory;


    public LadderController(LadderConnectStrategy ladderConnectStrategy,
                            LadderGameResultService ladderGameResultService) {
        this.ladderLineFactory = new LadderLineFactory(ladderConnectStrategy);
        this.ladderGameResultService = ladderGameResultService;
    }

    public void gameStart() {
        People people = new People(InputView.personNameInput());

        Rewards rewards = new Rewards(InputView.splitResult());

        LadderLines ladderLines = ladderLineFactory.randomLadderLines(new LadderWidth(people.number()),
                new LadderHeight(InputView.ladderHeight()));

        OutputView.ladderCreateResult(people, ladderLines, rewards);

        List<Person> resultPersonList = ladderGameResultService.resultPersonList(people,
                new SearchPeopleNames(InputView.inputResultPeopleNames()));

        Result result = ladderGameResultService.ladderGameResult(new LadderGameResultDto(rewards, ladderLines),
                resultPersonList);

        OutputView.gameResult(LadderOutputConverter.resultOutput(result));
    }
}
