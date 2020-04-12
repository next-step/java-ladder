package ladder.domain;

import ladder.exception.ExceptionType;
import ladder.exception.LadderException;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    @Getter
    private List<LadderLine> ladderLines;
    @Getter
    private LadderReward ladderReward;

    public Ladder(List<String> userNames, int height, List<String> rewardValues) {
        List<LadderLine> ladderLines = IntStream.range(0, height)
                .mapToObj(value -> LadderLine.of(userNames.size()))
                .collect(Collectors.toList());

        LadderReward reward = new LadderReward(rewardValues);

        validRewardSize(reward, ladderLines.get(0).getSize());

        this.ladderLines = ladderLines;
        this.ladderReward = reward;
    }

    public String getReward(int startPosition) {
        int position = startPosition;

        for (LadderLine ladderLine : this.ladderLines) {
            position = ladderLine.move(position);
        }

        return ladderReward.getReward(position);
    }

    private void validRewardSize(LadderReward reward, int pointSize) {
        if (!reward.sameSize(pointSize)) {
            throw new LadderException(ExceptionType.INVALID_LINE_SIZE);
        }
    }
}
