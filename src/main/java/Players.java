import java.util.List;
import java.util.stream.IntStream;

public class Players {
    public static final int INVALID_PLAYER_NAME = -1;

    private final List<Player> values;

    public Players(List<Player> values) {
        this.values = values;
    }

    public int size() {
        return values.size();
    }

    public void appendPlayers(StringBuilder sb) {
        for (Player player : this.values) {
            sb.append(Constants.PADDING);
            sb.append(Constants.PADDING);
            sb.append(player);
            sb.append(" ".repeat(Math.max(0, 5 - player.nameLength())));
        }
    }

    public int playerPosition(String playerName) {
        return IntStream.range(0, this.values.size())
                .filter(i -> this.values.get(i).is(playerName))
                .findFirst()
                .orElse(INVALID_PLAYER_NAME);
    }

    public String nameAt(int position) {
        return this.values.get(position).toString();
    }
}
