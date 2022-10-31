package ladder;

import ladder.domain.LadderTextInput;
import ladder.domain.person.Person;
import ladder.domain.person.SearchPeopleNames;
import ladder.domain.Result;
import ladder.domain.Rewards;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.LadderWidth;
import ladder.domain.person.People;
import ladder.domain.ladder.ladderline.LadderLines;
import ladder.dto.LadderCreateResultOutputDto;
import ladder.dto.LadderGameResultDto;
import ladder.service.LadderGameCreateService;
import ladder.service.LadderGameResultService;
import ladder.util.LadderOutputConverter;
import ladder.view.InputView;
import ladder.view.output.LadderGameCreateOutputView;
import ladder.view.output.LadderGameResultOutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class LadderController {

    private final LadderGameCreateService ladderGameCreateService;
    private final LadderGameResultService ladderGameResultService;

    public LadderController(LadderGameCreateService ladderGameCreateService, LadderGameResultService ladderGameResultService) {
        this.ladderGameCreateService = ladderGameCreateService;
        this.ladderGameResultService = ladderGameResultService;
    }

    public void gameStart() {
        People people = inputPeople();

        Rewards rewards = inputPlayResult();

        LadderLines ladderLines = ladderGameCreateService.createLadderLine(new LadderWidth(people.number()), inputHeight());

        LadderGameCreateOutputView.result(new LadderCreateResultOutputDto(people, ladderLines, rewards));

        SearchPeopleNames searchPeopleNames = inputResultPersonName();

        List<Person> personList = people.findByName(searchPeopleNames.peopleNames().stream()
                .map(LadderTextInput::text)
                .collect(Collectors.toList()));

        Result result = ladderGameResultService.ladderGameResult(new LadderGameResultDto(rewards, ladderLines), personList);

        LadderGameResultOutputView.result(LadderOutputConverter.resultMapOutput(result));
    }

    private People inputPeople() {
        try {
            return ladderGameCreateService.people(InputView.personNameInput());
        } catch (Exception e) {
            LadderGameCreateOutputView.inputPeopleException();
        }
        return inputPeople();
    }

    private Rewards inputPlayResult() {
        try {
            return new Rewards(InputView.splitResult());
        } catch (Exception e) {
            LadderGameCreateOutputView.inputPlayResultException();
        }
        return inputPlayResult();
    }

    private static LadderHeight inputHeight() {
        try {
            return new LadderHeight(InputView.ladderHeight());
        } catch (Exception e) {
            LadderGameCreateOutputView.inputLadderHeightException();
        }
        return inputHeight();
    }

    private static SearchPeopleNames inputResultPersonName() {
        try {
            return new SearchPeopleNames(Arrays.stream(InputView.inputResultPersonName())
                    .map(LadderTextInput::new)
                    .collect(Collectors.toList()));
        } catch (Exception e) {
            LadderGameResultOutputView.inputResultPersonNameException();
        }
        return inputResultPersonName();
    }
}
