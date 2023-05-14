package nextstep.laddergame.domain.ladder;

import nextstep.laddergame.domain.participant.Participants;
import nextstep.laddergame.domain.reward.Rewards;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(final int ladderHeight, final int participantsCount) {
        this.checkHeight(ladderHeight);

        this.lines = IntStream.range(0, ladderHeight)
                .mapToObj(height -> new Line(participantsCount))
                .collect(Collectors.toList());
    }

    private void checkHeight(int ladderHeight) {
        if (ladderHeight == 0) {
            throw new IllegalArgumentException("사다리 높이는 1칸 이상이여야합니다.");
        }
    }

    public List<Line> getLinesToPrint() {
        return this.lines;
    }

    public String ladderGameOnePerson(Participants participants, Rewards rewards, String selectedParticipant) {
        int currentIndex = participants.indexByName(selectedParticipant);

        for (Line line : this.lines) {
            currentIndex = line
                    .nextIndex(currentIndex);
        }

        return rewards.getRewardBy(currentIndex)
                .getReward();
    }

    public List<String> ladderGameAllPerson(Participants participants, Rewards rewards) {
        return participants.getNames()
                .stream()
                .map(name -> name + " : " + this.ladderGameOnePerson(participants, rewards, name))
                .collect(Collectors.toList());
    }
}
