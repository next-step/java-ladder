import java.util.List;

public class Players {
    private final List<Player> values;

    public Players(List<Player> values) {
        this.values = values;
    }

    public void appendPlayers(StringBuilder sb) {
        for (Player player : this.values) {
            sb.append(Constants.PADDING);
            sb.append(player);
            sb.append(" ".repeat(Math.max(0, 5 - player.nameLength())));
        }
    }
}
