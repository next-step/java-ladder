package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.Arrays;
import java.util.Objects;

public class LadderRideGame {

    private static String SPLIT_DELIMITER = ",";

    public void start() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Participants participants = checkUsers(inputView.inputParticipants());
        // TODO 사다리 결과 입력
        LadderResult ladderResult = checkLadderResult(inputView.inputLadderResult());
        Height height = checkHeight(inputView.inputLadderHeight());

        Ladder ladder = Ladder.valueOf(participants, height);

        // TODO +사다리 결과 출력
        resultView.printResult(ladder, participants);
        // TODO 결과 보고 싶은 사람 출력
        resultView.printUser(inputView.inputUserResult(), ladderResult);
    }

    private LadderResult checkLadderResult(String inputResult) {
        return null;
    }

    private Height checkHeight(int inputLadderHeight) {
        return Height.valueOf(inputLadderHeight);
    }

    private Participants checkUsers(String inputParticipants) {
        if(Objects.isNull(inputParticipants) || inputParticipants.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
        return Participants.valueOf(parseStringToArrays(inputParticipants));
    }

    private String[] parseStringToArrays(final String users) {
        return Arrays.stream(users.split(SPLIT_DELIMITER))
                .map(String::trim)
                .toArray(String[]::new);
    }
}
