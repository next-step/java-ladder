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
import ladder.dto.LadderGameResultDto;
import ladder.service.LadderGameCreateService;
import ladder.service.LadderGameResultService;
import ladder.util.LadderOutputConverter;
import ladder.view.InputView;
import ladder.view.OutputView;

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

        OutputView.ladderCreateResult(people, ladderLines, rewards);

        List<Person> resultPersonList = ladderGameResultService.resultPersonList(people, inputResultPersonName());

        Result result = ladderGameResultService.ladderGameResult(new LadderGameResultDto(rewards, ladderLines), resultPersonList);

        OutputView.gameResult(LadderOutputConverter.resultOutput(result));
    }


    private People inputPeople() {
        try {
            return new People(InputView.personNameInput());
        } catch (Exception e) {
            System.out.println("사람 이름 입력이 잘못됐습니다 다시 이력해주세요.");
        }
        return inputPeople();
    }

    private Rewards inputPlayResult() {
        try {
            return new Rewards(InputView.splitResult());
        } catch (Exception e) {
            System.out.println("사다리 게임 실행 결과 입력이 잘못됐습니다 다시 입력해주세요.");
        }
        return inputPlayResult();
    }

    private static LadderHeight inputHeight() {
        try {
            return new LadderHeight(InputView.ladderHeight());
        } catch (Exception e) {
            System.out.println("사다리 높이 입력이 잘못됐습니다 다시 입력해주세요.");
        }
        return inputHeight();
    }

    private static SearchPeopleNames inputResultPersonName() {
        try {
            return new SearchPeopleNames(Arrays.stream(InputView.inputResultPersonName())
                    .map(LadderTextInput::new)
                    .collect(Collectors.toList()));
        } catch (Exception e) {
            System.out.println("결과를 보고 싶은 사람 이름 입력이 잘못됐습니다 다시 입력해주세요");
        }
        return inputResultPersonName();
    }
}
