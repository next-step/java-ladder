package ladder.domain;

import ladder.exception.PlayerNameLengthExceedException;

import java.util.List;
import java.util.Objects;

public class Player {
    public static final int MAX_PLAYER_NAME = 5;
//    public static int autoIncrement = 0;
    private final String name;
//    private final int no;

    public Player(String name) {
        if (name.length() > MAX_PLAYER_NAME) {
            throw new PlayerNameLengthExceedException(name.length());
        }
//        this.no = no;
        this.name = name;
    }

    public String name() {
        return this.name;
    }

//    public LadderResult result(Ladder ladder, List<String> rewards) {
//        int resultIndex = ladder.result(this.no);
//        return new LadderResult(this, rewards.get(resultIndex));
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public boolean nameEquals(String playerName) {
        return this.name.equals(playerName);
    }
}
