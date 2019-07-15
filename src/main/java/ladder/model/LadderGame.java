package ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    public static final String MESSAGE_OF_SIZE_NOT_EQUAL = "참여자와 보상 갯수가 맞지 않습니다.";

    private final Participants participants;
    private final Rewards rewards;

    public LadderGame(List<String> participantNames, List<String> rewardNames) {
        if (participantNames.size() != rewardNames.size()) {
            throw new IllegalArgumentException(MESSAGE_OF_SIZE_NOT_EQUAL);
        }

        participants = new Participants(participantNames);
        rewards = new Rewards(rewardNames);
    }

    public Ladder initGame(int height) {
        final int width = participants.size();
        return Ladder.generateRandom(height, width);
    }

    public Result run(Ladder ladder) {
        final List<Integer> arrivalIndex = ridingLadder(ladder);
        return new Result(participants, rewards, arrivalIndex);
    }

    private List<Integer> ridingLadder(Ladder ladder) {
        return IntStream.range(0, participants.size())
                        .boxed()
                        .map(ladder::move)
                        .collect(Collectors.toList());
    }

    public Participants getParticipants() {
        return participants;
    }

    public Rewards getRewards() {
        return rewards;
    }
}
