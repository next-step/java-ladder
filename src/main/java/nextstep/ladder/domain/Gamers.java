package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
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

    public Gamers climb(Ladder ladder) {
        return gamers.stream()
                .map(gamer -> gamer.climb(ladder))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Gamers::new));
    }

    public ExecutionResult matchResult(List<String> executionResult) {
        return gamers.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(
                                Function.identity(),
                                gamer -> gamer.match(executionResult)
                        ), ExecutionResult::of));

    }

    public List<Gamer> getGamers() {
        return Collections.unmodifiableList(gamers);
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
