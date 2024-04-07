package ladder.domain.participants;

import ladder.domain.Ladder.Ladder;
import ladder.domain.result.RewardResult;
import ladder.domain.participants.factory.GamerFactory;
import ladder.domain.result.Reward;
import ladder.utils.SplitUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Participants {

    private final List<Gamer> gamers;

    public Participants(String inputText) {
        this(SplitUtils.split(inputText));
    }

    public Participants(String[] names) {
        this(GamerFactory.generateGamers(names));
    }

    public Participants(List<Gamer> gamers) {
        this.gamers = gamers;
    }

    public List<Gamer> getGamers() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participants)) return false;
        Participants that = (Participants) o;
        return Objects.equals(gamers, that.gamers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gamers);
    }
}
