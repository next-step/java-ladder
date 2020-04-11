package nextstep.ladder.domain.gamer;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Gamers {
    private static final String INSTANTIATE_ERROR_FORMAT = "Create Gamer fail. name must be at least 1 character and 5 characters : name=%s";
    private static final int MAX_GAMER_STRING_LENGTH = 5;
    private final List<String> gamers;

    private Gamers(List<String> gamers) {
        this.gamers = gamers;
    }

    public static Gamers of(List<String> gamers) {
        if (gamers.stream()
                .anyMatch(gamerName -> gamerName.length() > MAX_GAMER_STRING_LENGTH)) {
            throw new IllegalArgumentException(String.format(INSTANTIATE_ERROR_FORMAT, gamers));
        }
        return new Gamers(gamers);
    }

    public int getLadderNumber(String gamer) {
        return gamers.indexOf(gamer);
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

    @Override
    public String toString() {
        return "Gamers{" +
                "gamers=" + gamers +
                '}';
    }

    public int size() {
        return gamers.size();
    }
}