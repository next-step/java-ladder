package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Players {

    private List<Player> players = new ArrayList<>();

    public Players(String[] strings) {
        for (String string : strings) {
            players.add(new Player(new UserName(string)));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}
