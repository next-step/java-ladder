package ladder.domain;

import ladder.exception.PlayerNameLengthExceedException;

import java.util.List;
import java.util.Objects;

public class Player {
    public static final int MAX_PLAYER_NAME = 5;
    public static int autoIncrement = 0;
    private final String name;
    private final int no;

    public Player(String name, int no) {
        if (name.length() > MAX_PLAYER_NAME) {
            throw new PlayerNameLengthExceedException(name.length());
        }
        this.no = no;
        this.name = name;
    }

    public Player(String name) {
        this(name, autoIncrement++);
    }


    public String name() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return no == player.no && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, no);
    }

    public int no() {
        return this.no;
    }

    public LadderResult result(Ladder ladder, List<String> rewards) {
        int resultIndex = ladder.result(this.no);
        return new LadderResult(this, rewards.get(resultIndex));
    }

    public boolean nameEquals(String playerName) {
        return this.name == playerName;
    }
}
