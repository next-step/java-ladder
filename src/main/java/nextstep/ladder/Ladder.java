package nextstep.ladder;

import nextstep.ladder.line.Lines;
import nextstep.ladder.player.Entries;

public class Ladder {

    private Lines lines;
    private Entries players;

    public Ladder(Lines lines, Entries players) {
        this.lines = lines;
        this.players = players;
    }

    public void play() {
        players.move(lines);
    }

    @Override
    public String toString() {
        return players.toString() + "\n" + lines.toString();
    }
}
