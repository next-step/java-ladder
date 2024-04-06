package ladder.domain.participants;

import ladder.domain.Ladder.Ladder;
import ladder.domain.result.RewardResult;
import ladder.domain.participants.factory.ParticipantsFactory;
import ladder.domain.result.Reward;
import ladder.utils.SplitUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private final List<Gamer> gamers;

    public Participants(String inputText) {
        this(SplitUtils.split(inputText));
    }

    public Participants(String[] names) {
        this(ParticipantsFactory.generateGamers(names));
    }

    public Participants(List<Gamer> gamers) {
        this.gamers = gamers;
    }

    public List<Gamer> getNames() {
        return Collections.unmodifiableList(gamers);
    }

    public Participants startGame(Ladder ladder) {
        return new Participants(gamers.stream()
                .map(gamer -> gamer.climb(ladder))
                .collect(Collectors.toUnmodifiableList()));
    }

    public RewardResult mapTo(Reward reward) {
        return gamers.stream()
                .filter(gamer -> gamer.hasSamePosition(reward))
                .map(gamer -> new RewardResult(reward, gamer))
                .findFirst().orElseThrow();
    }

    public int count() {
        return this.gamers.size();
    }
}
