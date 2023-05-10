package nextstep.ladder.domain.line;

import nextstep.ladder.domain.participant.Participants;
import nextstep.ladder.domain.reward.Rewards;
import nextstep.ladder.vo.DirectionType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lines {
    private final List<Line> lines;

    public Lines(int ladderLength, int participantsCount) {
        this.lines = this.makeLine(ladderLength, participantsCount);
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    private List<Line> makeLine(int ladderLength, int participantsCount) {
        final List<Line> lines = new ArrayList<>();

        for (int i = 0; i < ladderLength; i++) {
            lines.add(new Line(participantsCount));
        }

        return lines;
    }

    public String rewardOnePerson(Participants participants, Rewards rewards, String name) {
        int col = 0;
        int row = participants.indexByName(name);

        while (col < this.lines.size()) {
            row += DirectionType
                    .checkDirection(row, col, this)
                    .moveRow();
            col += 1;
        }

        return rewards.getRewardBy(row).getReward();
    }

    public boolean isLeftDirection(int row, int col) {
        return this.lines.get(col).currentPoint(row);
    }

    public boolean isRightDirection(int row, int col) {
        return this.lines.get(col).nextPoint(row);
    }

    public List<String> rewardAll(Participants participants, Rewards rewards) {
        return participants.getNames()
                .stream().map(name -> name + " : " + this.rewardOnePerson(participants, rewards, name))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
