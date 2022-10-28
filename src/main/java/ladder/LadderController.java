package ladder;

import ladder.domain.result.ResultMap;
import ladder.domain.result.Results;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.LadderWidth;
import ladder.domain.person.People;
import ladder.domain.ladder.ladderline.LadderLines;
import ladder.domain.person.Person;
import ladder.service.LadderGameCreateService;
import ladder.service.LadderGameResultService;
import ladder.util.LadderOutputConverter;
import ladder.view.InputView;
import ladder.view.output.LadderGameCreateOutputView;
import ladder.view.output.LadderGameResultOutputView;

import java.util.List;

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

        LadderGameCreateOutputView.result(
                LadderOutputConverter.peopleName(people),
                LadderOutputConverter.ladderLinesOutput(ladderLines),
                LadderOutputConverter.resultOutput(results));

        List<Person> resultPersonList = inputResultPersonName(people);

        ResultMap resultMap = ladderGameResultService.ladderGameResult(results, ladderLines, resultPersonList);

        LadderGameResultOutputView.result(LadderOutputConverter.resultMapOutput(resultMap, resultPersonList));
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

    private static List<Person> inputResultPersonName(People people) {
        try {
            return people.findByName(InputView.inputResultPersonName());
        } catch (Exception e) {
            LadderGameResultOutputView.inputResultPersonNameException();
        }
        return inputResultPersonName(people);
    }
}
