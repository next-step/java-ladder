package nextstep.ladder.domain;

import nextstep.ladder.dto.GamersDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Gamers {
    private final List<Gamer> gamers;
    public Gamers(List<Gamer> gamers) {
        this.gamers = gamers;
    }

    public static Gamers from(List<String> names) {
        List<Gamer> gamers = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            gamers.add(Gamer.of(names.get(i), i));
        }
        return new Gamers(gamers);
    }

    public int size() {
        return gamers.size();
    }

    public GamersDto toDto() {
        return gamers.stream()
                .map(Gamer::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), GamersDto::of));
    }

    public Gamers climb(Ladder ladder) {
        return gamers.stream()
                .map(gamer -> gamer.climb(ladder))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Gamers::new));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gamers gamers1 = (Gamers) o;
        return Objects.equals(gamers, gamers1.gamers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gamers);
    }
}
