package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private final Participants participantNames;
    private final Rewards rewards;
    private final Ladder ladder;

    public LadderGame(Participants participantNames, Rewards rewards, Ladder ladder) {
        this.participantNames = participantNames;
        this.rewards = rewards;
        this.ladder = ladder;
    }

    public Results play() {
        List<Result> resultList = IntStream.range(0, participantNames.getParticipantsCount())
                .mapToObj(index -> {
                    int finalIndex = ladder.move(index);
                    String name = participantNames.getName(index);
                    String reward = rewards.getReward(finalIndex);
                    return new Result(name, reward);
                })
                .collect(Collectors.toList());
        return new Results(resultList);
    }
}
