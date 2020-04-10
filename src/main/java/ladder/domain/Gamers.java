package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Gamers {
    private static final String INSTANTIATE_ERROR_FORMAT = "Create Gamers fail. gamers must be at least %d players: name=%s";
    private static final int MINIMUM_SIZE = 2;
    private final List<Gamer> gamers;

    private Gamers(List<Gamer> gamers) {
        this.gamers = Collections.unmodifiableList(gamers);
    }

    public static Gamers of(List<String> gamers) {
        if (gamers.size() < MINIMUM_SIZE) {
            throw new IllegalArgumentException(String.format(INSTANTIATE_ERROR_FORMAT, MINIMUM_SIZE, Arrays.toString(gamers.toArray())));
        }
        return new Gamers(getGamerList(gamers.toArray(new String[0])));
    }

    private static List<Gamer> getGamerList(String[] names) {
        return IntStream.range(0, names.length)
                .mapToObj(idx -> createNextGamer(idx, names))
                .collect(Collectors.toList());
    }

    private static Gamer createNextGamer(int idx, String[] names) {
        return Gamer.of(names[idx], idx);
    }

    public List<Gamer> getGamers() {
        return gamers;
    }

    public int size(){
        return gamers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gamers gamers = (Gamers) o;
        return Objects.equals(this.gamers, gamers.gamers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gamers);
    }

    @Override
    public String toString() {
        return "Gamers{" +
                "gamerList=" + gamers +
                '}';
    }
}
