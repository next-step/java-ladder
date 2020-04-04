package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Gamers {
    private final List<Gamer> gamerList;

    private Gamers(List<Gamer> gamerList) {
        this.gamerList = gamerList;
    }

    public static Gamers ofComma(String name) {
        String[] names = name.split(",");
        return new Gamers(IntStream.rangeClosed(1, name.length())
                .mapToObj(number -> Gamer.of(names[number - 1], number))
                .collect(Collectors.toList()));
    }

    public List<Gamer> getGamerList() {
        return gamerList;
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
}
