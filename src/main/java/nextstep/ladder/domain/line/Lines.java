package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Lines {
    private final List<Line> lines;
    private final Rewards rewards;


    public Lines(int ladderLength, int participantsCount, String rewards) {
        final List<String> splitRewards = this.splitRewards(rewards);
        this.checkRewardSize(participantsCount, splitRewards);

        this.lines = this.makeLine(ladderLength, participantsCount);
        this.rewards = this.makeRewards(splitRewards);
    }

    private List<String> splitRewards(String rewards) {
        return List.of(Optional.ofNullable(rewards)
                .map(it -> it.split(","))
                .orElseThrow(() -> new IllegalArgumentException("보상은 빈값일 수 없습니다.")));
    }

    private void checkRewardSize(int participantsCount, List<String> rewards) {
        if (rewards.size() != participantsCount) {
            throw new IllegalArgumentException("보상은 인원수와 같아야합니다.");
        }
    }


    private List<Line> makeLine(int ladderLength, int participantsCount) {
        final List<Line> lines = new ArrayList<>();

        for (int i = 0; i < ladderLength; i++) {
            lines.add(new Line(participantsCount));
        }

        return lines;
    }

    private Rewards makeRewards(List<String> rewards) {
        return new Rewards(rewards);
    }

    public List<Line> getLines() {
        return this.lines;
    }

    public List<String> getRewards() {
        return this.rewards.getReward();
    }
}
