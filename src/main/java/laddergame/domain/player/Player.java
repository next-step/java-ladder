package laddergame.domain.player;

import laddergame.domain.vo.Column;
import laddergame.domain.vo.Name;
import laddergame.domain.vo.Position;

public class Player {
    private final Name name;
    private final Column column;

    public Player(String name, int column) {
        this.name = new Name(name);
        this.column = new Column(column);
    }

    public String getName() {
        return this.name.getName();
    }

    public Column getColumn() {
        return column;
    }

    public boolean isSameName(final String name) {
        return this.name.isSameName(name);
    }
}
