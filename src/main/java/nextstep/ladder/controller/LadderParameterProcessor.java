package nextstep.ladder.controller;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Reward;
import nextstep.ladder.view.InputView;
import nextstep.ladder.wrapper.LadderRewards;
import nextstep.ladder.wrapper.Participants;

import java.util.Arrays;
import java.util.Objects;

public class LadderParameterProcessor {

    private static final String GUIDE_ERR_NOT_EQUALS_SIZE = "참여자 수에 일치하는 결과 값을 입력해야 합니다.";
    private static final String GUIDE_ERR_INPUT_DATA = "입력 값이 없습니다.";
    private static final String SPLIT_DELIMITER = ",";

    private final InputView inputView;

    LadderParameterProcessor(InputView inputView) {
        this.inputView = inputView;
    }

    Participants processUsers() {
        String participants = inputView.inputParticipants();
        checkNullOrEmpty(participants);
        return Participants.valueOf(parseStringToArrays(participants));
    }

    LadderRewards processLadderRewards(int participantSize) {
        String[] ladderRewards = parseStringToArrays(inputView.inputLadderRewards());
        Reward[] rewards = parseRewards(ladderRewards);
        if(ladderRewards.length != participantSize) {
            throw new IllegalArgumentException(GUIDE_ERR_NOT_EQUALS_SIZE);
        }
        return LadderRewards.valueOf(rewards);
    }

    Height processHeight() {
        String ladderHeight = inputView.inputLadderHeight();
        checkNullOrEmpty(ladderHeight);
        return Height.valueOf(Integer.parseInt(ladderHeight));
    }


    String inputUserResult() {
        String userResult = inputView.inputUserResult();
        checkNullOrEmpty(userResult);
        return userResult;
    }

    private Reward[] parseRewards(final String[] ladderRewards) {
        return Arrays.stream(ladderRewards)
                .map(Reward::valueOf)
                .toArray(Reward[]::new);
    }

    private void checkNullOrEmpty(String inputValue) {
        if (Objects.isNull(inputValue) || inputValue.isEmpty()) {
            throw new IllegalArgumentException(GUIDE_ERR_INPUT_DATA);
        }
    }

    private String[] parseStringToArrays(final String words) {
        return Arrays.stream(words.split(SPLIT_DELIMITER))
                .map(String::trim)
                .toArray(String[]::new);
    }
}
