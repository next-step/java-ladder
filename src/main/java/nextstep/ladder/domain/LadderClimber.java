package nextstep.ladder.domain;

import java.util.Collections;
import java.util.stream.IntStream;

public class LadderClimber {
    private final Lines lines;
    private final Players players;

    public LadderClimber(Players players, Lines lines) {
        this.players = players;
        this.lines = lines;
    }

    public PlayersOnLines climb() {
        PlayersOnLine firstPlayersOnLine = new PlayersOnLine(players);
        PlayersOnLines playersOnLines = new PlayersOnLines(Collections.singletonList(firstPlayersOnLine));

        IntStream.range(0, lines.getHeight())
                .forEach(heightPoint -> {
                    PlayersOnLine newPlayersOnLine = createNextPlayersOnLine(playersOnLines.getLast(), heightPoint);
                    playersOnLines.add(newPlayersOnLine);
                });

        return playersOnLines;
    }

    private PlayersOnLine createNextPlayersOnLine(PlayersOnLine playersOnLine, int heightPoint) {
        Connections connections = lines.getConnections(heightPoint);
        PlayersOnLine newPlayersOnLine = new PlayersOnLine(playersOnLine.getPlayers());
        IntStream.range(0, players.getSize() - 1)
                .forEach(widthPoint -> crossConnections(connections, newPlayersOnLine, widthPoint));

        return newPlayersOnLine;
    }

    private void crossConnections(Connections connections, PlayersOnLine newPlayersOnLine, int widthPoint) {
        if (connections.isConnected(widthPoint)) {
            newPlayersOnLine.swapWithNext(widthPoint);
        }
    }
}
