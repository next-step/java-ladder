package ladder;

import ladder.domain.LadderTextInput;
import ladder.domain.person.Person;
import ladder.domain.person.SearchPeopleNames;
import ladder.domain.result.ResultMap;
import ladder.domain.result.Results;
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

        Results results = inputPlayResult();

        LadderLines ladderLines = ladderGameCreateService.createLadderLine(new LadderWidth(people.number()), inputHeight());

        LadderGameCreateOutputView.result(new LadderCreateResultOutputDto(people, ladderLines, results));

        SearchPeopleNames searchPeopleNames = inputResultPersonName();

        List<Person> personList = people.findByName(searchPeopleNames.peopleNames().stream()
                .map(LadderTextInput::text)
                .collect(Collectors.toList()));

        ResultMap resultMap = ladderGameResultService.ladderGameResult(new LadderGameResultDto(results, ladderLines), personList);

        LadderGameResultOutputView.result(LadderOutputConverter.resultMapOutput(resultMap));
    }

    private People inputPeople() {
        try {
            return ladderGameCreateService.people(InputView.personNameInput());
        } catch (Exception e) {
            LadderGameCreateOutputView.inputPeopleException();
        }
        return inputPeople();
    }

    private Results inputPlayResult() {
        try {
            return new Results(InputView.splitResult());
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
