package ladder;

import java.util.stream.Collectors;
import ladder.domain.ladder.ladderline.LadderLineFactory;
import ladder.domain.ladder.strategy.LadderConnectStrategy;
import ladder.domain.person.Person;
import ladder.domain.person.PersonName;
import ladder.domain.person.SearchPeopleNames;
import ladder.domain.Result;
import ladder.domain.Rewards;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.LadderWidth;
import ladder.domain.person.People;
import ladder.domain.ladder.ladderline.LadderLines;
import ladder.dto.LadderGameResultDto;
import ladder.util.LadderOutputConverter;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderController {

    private final LadderLineFactory ladderLineFactory;


    public LadderController(LadderConnectStrategy ladderConnectStrategy) {
        this.ladderLineFactory = new LadderLineFactory(ladderConnectStrategy);
    }

    public void gameStart() {
        People people = new People(InputView.personNameInput());

        Rewards rewards = new Rewards(InputView.splitResult());

        LadderLines ladderLines = ladderLineFactory.randomLadderLines(new LadderWidth(people.number()),
                new LadderHeight(InputView.ladderHeight()));

        OutputView.ladderCreateResult(people, ladderLines, rewards);

        SearchPeopleNames searchPeopleNames = new SearchPeopleNames(InputView.inputResultPeopleNames());

        List<Person> resultPersons = people.findByName(searchPeopleNames.peopleNames().stream()
                .map(PersonName::name)
                .collect(Collectors.toList()));

        Result result = new Result(new LadderGameResultDto(rewards, ladderLines), resultPersons);

        OutputView.gameResult(LadderOutputConverter.resultOutput(result));
    }
}
