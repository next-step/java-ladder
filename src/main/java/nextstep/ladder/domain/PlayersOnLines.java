package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayersOnLines {
    private List<PlayersOnLine> playersOnLines;

    public PlayersOnLines(List<PlayersOnLine> playersOnLines) {
        this.playersOnLines = new ArrayList<>(playersOnLines);
    }

    public void add(PlayersOnLine playersOnLine) {
        this.playersOnLines.add(playersOnLine);
    }

    public PlayersOnLine getLast() {
        return playersOnLines.get(playersOnLines.size() - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayersOnLines that = (PlayersOnLines) o;
        return Objects.equals(playersOnLines, that.playersOnLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playersOnLines);
    }
}
