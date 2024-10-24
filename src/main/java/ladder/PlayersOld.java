package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PlayersOld {

    private final List<PlayerOld> playerOlds;

    public PlayersOld(String... player) {
        this(Arrays.stream(player).map(PlayerOld::new).collect(Collectors.toList()));
    }

    public PlayersOld(List<PlayerOld> playerOlds) {
        validNames(playerOlds);
        validSize(playerOlds);
        this.playerOlds = playerOlds;
    }

    public int size() {
        return playerOlds.size();
    }

    private void validSize(List<PlayerOld> playerOlds) {
        if (playerOlds.size() < 2) {
            throw new IllegalArgumentException();
        }
    }

    private void validNames(List<PlayerOld> playerOlds) {
        int initSize = playerOlds.size();
        long distinctSize = playerOlds.stream()
            .distinct()
            .count();

        if (initSize != distinctSize) {
            throw new IllegalArgumentException("player name is not distinct");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof PlayersOld))
            return false;
        PlayersOld that = (PlayersOld)o;
        return Objects.equals(playerOlds, that.playerOlds);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(playerOlds);
    }

    public List<PlayerOld> getPlayers() {
        return playerOlds;
    }

    public String get(int index) {
        return playerOlds.get(index).getName();
    }
}
