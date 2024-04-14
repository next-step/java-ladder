package ladder.domain.participants;

import ladder.domain.ladders.LadderGame;
import ladder.domain.participants.factory.GamerFactory;
import ladder.domain.result.GameRecords;
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

    public GameRecords startGame(LadderGame ladder) {
        return new GameRecords(gamers.stream()
                .map(gamer -> gamer.climb(ladder))
                .collect(Collectors.toUnmodifiableList()));
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
