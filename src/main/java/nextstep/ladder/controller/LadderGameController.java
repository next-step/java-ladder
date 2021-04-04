package nextstep.ladder.controller;

import nextstep.ladder.Service.LadderService;
import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.Arrays;
import java.util.Objects;

public class LadderGameController {

    private static final String SPLIT_DELIMITER = ",";
    public static final String GUIDE_ERR_NOT_EQUALS_SIZE = "참여자 수에 일치하는 결과 값을 입력해야 합니다.";
    public static final String GUIDE_ERR_INPUT_DATA = "입력 값이 없습니다.";

    public void start() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Participants participants = checkUsers(inputView.inputParticipants());
        // DONE 사다리 보상 입력
        LadderRewards ladderRewards = checkLadderRewards(inputView.inputLadderRewards(), participants.size());
        Height height = checkHeight(inputView.inputLadderHeight());

        Ladder ladder = Ladder.valueOf(participants, height);

        LadderService.run(participants, ladder, ladderRewards);
        // TODO +사다리 결과 출력
        resultView.printResult(ladder, participants, ladderRewards);
        // TODO 결과 보고 싶은 사람 출력
        resultView.printUser(inputView.inputUserResult(), ladderRewards);
    }

    private LadderRewards checkLadderRewards(String inputResult, int participantSize) {
        String[] ladderRewards = parseStringToArrays(inputResult);
        if(ladderRewards.length != participantSize) {
            throw new IllegalArgumentException(GUIDE_ERR_NOT_EQUALS_SIZE);
        }
        return LadderRewards.valueOf(ladderRewards);
    }

    private Height checkHeight(int inputLadderHeight) {
        return Height.valueOf(inputLadderHeight);
    }

    private Participants checkUsers(String inputParticipants) {
        if(Objects.isNull(inputParticipants) || inputParticipants.isEmpty()) {
            throw new IllegalArgumentException(GUIDE_ERR_INPUT_DATA);
        }
        return Participants.valueOf(parseStringToArrays(inputParticipants));
    }

    private String[] parseStringToArrays(final String users) {
        return Arrays.stream(users.split(SPLIT_DELIMITER))
                .map(String::trim)
                .toArray(String[]::new);
    }
}
