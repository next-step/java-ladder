package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Gamers {
    private static final String INSTANTIATE_ERROR_FORMAT = "Create Gamers fail. gamers must be at least %d players: name=%s";
    private static final int MINIMUM_SIZE = 2;
    private final List<Gamer> gamerList;

    private Gamers(List<Gamer> gamerList) {
        this.gamerList = Collections.unmodifiableList(gamerList);
    }

    public static Gamers ofComma(String name) {
        String[] names = name.split(",");
        if (names.length < MINIMUM_SIZE) {
            throw new IllegalArgumentException(String.format(INSTANTIATE_ERROR_FORMAT, MINIMUM_SIZE, name));
        }
        return new Gamers(getGamerList(names));
    }

    private static List<Gamer> getGamerList(String[] names) {
        return IntStream.range(0, names.length)
                .mapToObj(idx -> createNextGamer(idx, names))
                .collect(Collectors.toList());
    }

    private static Gamer createNextGamer(int idx, String[] names) {
        return Gamer.of(names[idx], idx);
    }

    public List<Gamer> getGamerList() {
        return gamerList;
    }

    public int size(){
        return gamerList.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gamers gamers = (Gamers) o;
        return Objects.equals(gamerList, gamers.gamerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gamerList);
    }

    @Override
    public String toString() {
        return "Gamers{" +
                "gamerList=" + gamerList +
                '}';
    }
}
