package nextstep.ladder.controller;

import nextstep.ladder.service.LadderService;
import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import nextstep.ladder.wrapper.Ladder;
import nextstep.ladder.wrapper.LadderResult;
import nextstep.ladder.wrapper.LadderRewards;
import nextstep.ladder.wrapper.Participants;

import java.util.*;

public class LadderGameController {

    private static final String SPLIT_DELIMITER = ",";
    public static final String GUIDE_ERR_NOT_EQUALS_SIZE = "참여자 수에 일치하는 결과 값을 입력해야 합니다.";
    public static final String GUIDE_ERR_INPUT_DATA = "입력 값이 없습니다.";
    public static final String GUIDE_LADDER_END_SIGNATURE = "all";

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void start() {

        Participants participants = checkUsers(inputView.inputParticipants());
        LadderRewards ladderRewards = checkLadderRewards(inputView.inputLadderRewards(), participants.size());
        Height height = checkHeight(inputView.inputLadderHeight());

        Ladder ladder = Ladder.valueOf(participants, height);

        LadderResult rewardResult = LadderService.rideLadder(participants, ladder, ladderRewards);
        resultView.printResult(ladder, participants, ladderRewards);

        String user;
        do {
            user = inputView.inputUserResult();
        } while (!isOneOrAll(rewardResult, user));
    }

    private boolean isOneOrAll(LadderResult rewardResult, String user) {
        if(user.equals(GUIDE_LADDER_END_SIGNATURE)) {
            resultView.printUserResult(rewardResult.findAll());
            return true;
        }
        User findUser = User.valueOf(user);
        resultView.printUserResult(rewardResult.findOf(findUser));
        return false;
    }

    private LadderRewards checkLadderRewards(String inputResult, int participantSize) {
        String[] ladderRewards = parseStringToArrays(inputResult);
        if(ladderRewards.length != participantSize) {
            throw new IllegalArgumentException(GUIDE_ERR_NOT_EQUALS_SIZE);
        }
        return LadderRewards.valueOf(ladderRewards);
    }

    private Height checkHeight(String inputLadderHeight) {
        checkNullOrEmpty(inputLadderHeight);
        return Height.valueOf(Integer.parseInt(inputLadderHeight));
    }

    private Participants checkUsers(String inputParticipants) {
        checkNullOrEmpty(inputParticipants);
        return Participants.valueOf(parseStringToArrays(inputParticipants));
    }

    private void checkNullOrEmpty(String inputLadderHeight) {
        if (Objects.isNull(inputLadderHeight) || inputLadderHeight.isEmpty()) {
            throw new IllegalArgumentException(GUIDE_ERR_INPUT_DATA);
        }
    }

    private String[] parseStringToArrays(final String users) {
        return Arrays.stream(users.split(SPLIT_DELIMITER))
                .map(String::trim)
                .toArray(String[]::new);
    }
}
