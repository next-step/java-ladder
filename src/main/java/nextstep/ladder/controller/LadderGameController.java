package nextstep.ladder.controller;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Position;
import nextstep.ladder.domain.Reward;
import nextstep.ladder.domain.User;
import nextstep.ladder.generator.DefaultLineGenerator;
import nextstep.ladder.generator.LineGenerator;
import nextstep.ladder.hint.HintLadder;
import nextstep.ladder.service.Ladder;
import nextstep.ladder.service.LadderResult;
import nextstep.ladder.service.LadderRewards;
import nextstep.ladder.service.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.*;

public class LadderGameController {

    private static final String GUIDE_ERR_NOT_EQUALS_SIZE = "참여자 수에 일치하는 결과 값을 입력해야 합니다.";
    private static final String GUIDE_ERR_INPUT_DATA = "입력 값이 없습니다.";
    private static final String SPLIT_DELIMITER = ",";

    public static final String GUIDE_LADDER_END_SIGNATURE = "all";
    private final InputView inputView;
    private final ResultView resultView;
    private final LineGenerator generator = new DefaultLineGenerator();

    public LadderGameController(final InputView inputView, final ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        Participants participants = inputParticipants();
        LadderRewards rewards = inputRewards(participants.size());
        Height height = inputHeight();

        Ladder ladder = Ladder.valueOf(participants, height, generator);
        LadderResult ladderResult = rideLadder(participants, ladder, rewards);

        resultView.printResult(ladder, participants, rewards);

        String user;
        do {
            user = inputUserResult();
        } while (!isOneOrAll(ladderResult, user));
    }

    public void hintStart() {
        Participants participants = inputParticipants();
        LadderRewards rewards = inputRewards(participants.size());
        Height height = inputHeight();

        HintLadder hintLadder = HintLadder.valueOf(participants, height);
        LadderResult ladderResult = rideLadder(participants, hintLadder, rewards);

        resultView.printResult(hintLadder, participants, rewards);

        String user;
        do {
            user = inputUserResult();
        } while (!isOneOrAll(ladderResult, user));
    }

    public LadderResult rideLadder(
            final Participants participants, final Ladder ladder, final LadderRewards ladderRewards) {

        Map<User, Reward> result = new LinkedHashMap<>();
        Set<User> users = participants.getUsers();

        for (User user : users) {
            Position rewardPosition = ladder.findEndPosition(user.position());
            Reward reward = ladderRewards.findReward(rewardPosition.currentPosition());
            result.put(user, reward);
        }

        return LadderResult.valueOf(result);
    }
    private LadderResult rideLadder(Participants participants, HintLadder hintLadder, LadderRewards rewards) {
        Map<User, Reward> result = new LinkedHashMap<>();
        Set<User> users = participants.getUsers();

        for (User user : users) {

            int movePosition = user.position().currentPosition();
            int rewardPosition = hintLadder.findEndPosition(movePosition);
            Reward reward = rewards.findReward(rewardPosition);
            result.put(user, reward);
        }

        return LadderResult.valueOf(result);
    }

    private Participants inputParticipants() {
        String participants = inputView.inputParticipants();
        checkNullOrEmpty(participants);
        return Participants.valueOf(parseStringToArrays(participants));
    }

    private LadderRewards inputRewards(final int participantSize) {
        String[] ladderRewards = parseStringToArrays(inputView.inputLadderRewards());
        if(ladderRewards.length != participantSize) {
            throw new IllegalArgumentException(GUIDE_ERR_NOT_EQUALS_SIZE);
        }
        return LadderRewards.valueOf(ladderRewards);
    }

    private Height inputHeight() {
        String ladderHeight = inputView.inputLadderHeight();
        checkNullOrEmpty(ladderHeight);
        return Height.valueOf(Integer.parseInt(ladderHeight));
    }

    private String inputUserResult() {
        String userResult = inputView.inputUserResult();
        checkNullOrEmpty(userResult);
        return userResult;
    }

    private void checkNullOrEmpty(final String inputValue) {
        if (Objects.isNull(inputValue) || inputValue.isEmpty()) {
            throw new IllegalArgumentException(GUIDE_ERR_INPUT_DATA);
        }
    }

    private String[] parseStringToArrays(final String words) {
        return Arrays.stream(words.split(SPLIT_DELIMITER))
                .map(String::trim)
                .toArray(String[]::new);
    }

    private boolean isOneOrAll(final LadderResult ladderResult, final String user) {
        if(user.equals(GUIDE_LADDER_END_SIGNATURE)) {
            resultView.printUserResult(ladderResult.findAll());
            return true;
        }
        User findUser = User.valueOf(user);
        resultView.printUserResult(ladderResult.findOf(findUser));
        return false;
    }
}
