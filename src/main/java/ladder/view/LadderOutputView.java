package ladder.view;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;
import ladder.view.io.Output;

public class LadderOutputView {

    private static final String PLAYER_NAME_PRINTING_FORMAT = "%-5s";
    private static final String PLAYER_NAME_JOIN_DELIMITER = " ";
    private static final Map<Boolean, String> LADDER_CONNECTION = Map.of(
            TRUE, "-----",
            FALSE, "     "
    );
    private static final String LADDER_COLUMN = "|";

    private final Output output;

    public LadderOutputView(final Output output) {
        this.output = output;
    }

    public void printPlayers(final Players players) {
        final String line = players.names()
                .stream()
                .map(name -> String.format(PLAYER_NAME_PRINTING_FORMAT, name))
                .collect(Collectors.joining(PLAYER_NAME_JOIN_DELIMITER));

        output.printLine(line);
    }

    public void printLadder(final Ladder ladder) {
        final String result = ladder.ladderDetail()
                .stream()
                .map(this::buildLine)
                .collect(Collectors.joining("\n"));

        output.printLine(result);
    }

    private String buildLine(final List<Boolean> line) {
        final String lineResult = line.stream()
                .map(LADDER_CONNECTION::get)
                .collect(Collectors.joining());

        return LADDER_COLUMN + lineResult + LADDER_COLUMN;
    }
}
