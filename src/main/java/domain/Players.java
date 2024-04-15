package domain;

import java.util.Iterator;
import java.util.List;

public class Players implements Iterable<Player> {

    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public int totalNumber() {
        return players.size();
    }

    public void accept(LadderVisitor visitor) {
        visitor.visit(players);
    }

    public Player findByOrder(int order) {
        return players.get(order);
    }

    @Override
    public Iterator<Player> iterator() {
        return players.iterator();
    }

    public Position getPosition(Player player) {
        return new Position(this.players.indexOf(player), 0);
    }

    public int getOrder(Player player) {
        return players.indexOf(player);
    }
}
