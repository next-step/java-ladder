package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Gamers {
    private final List<Gamer> gamerList;

    private Gamers(List<Gamer> gamerList) {
        this.gamerList = gamerList;
    }

    public static Gamers ofComma(String name) {
        return new Gamers(Arrays.stream(name.split(","))
                .map(Gamer::of)
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
