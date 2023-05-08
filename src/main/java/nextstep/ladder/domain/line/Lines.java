package nextstep.ladder.domain.line;

import nextstep.ladder.domain.participant.Participants;
import nextstep.ladder.domain.reward.Rewards;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lines {
    private final List<Line> lines;

    public Lines(int ladderLength, int participantsCount) {
        this.lines = this.makeLine(ladderLength, participantsCount);
    }

    private List<Line> makeLine(int ladderLength, int participantsCount) {
        final List<Line> lines = new ArrayList<>();

        for (int i = 0; i < ladderLength; i++) {
            lines.add(new Line(participantsCount));
        }

        return lines;
    }

    public String rewardOnePerson(Participants participants, Rewards rewards, String name) {
        int y = 0;
        int x = participants.indexByName(name);

        while (y < this.lines.size()) {
            if (this.isMoveLeft(x, y)) {
                x -= 1;
            } else if (this.isMoveRight(x, y)) {
                x += 1;
            }

            y += 1;
        }

        return rewards.getRewardBy(x).getReward();
    }

    public List<String> rewardAll(Participants participants, Rewards rewards) {
        return participants.getNames()
                .stream().map(name -> name + " : " + this.rewardOnePerson(participants, rewards, name))
                .collect(Collectors.toList());
    }

    private boolean isMoveLeft(int x, int y) {
        return this.lines.get(y).currentPoint(x);
    }

    private boolean isMoveRight(int x, int y) {
        return this.lines.get(y).nextPoint(x);
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
