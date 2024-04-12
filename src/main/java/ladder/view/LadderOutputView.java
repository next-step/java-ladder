package ladder.view;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.text.MessageFormat.format;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ladder.domain.item.Item;
import ladder.domain.item.Items;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.result.Result;
import ladder.view.io.Output;

public class LadderOutputView {

    private static final String NAME_PRINTING_FORMAT = "%-5s";
    private static final String NAME_JOIN_DELIMITER = " ";
    private static final Map<Boolean, String> LADDER_CONNECTION = Map.of(
            TRUE, "-----",
            FALSE, "     "
    );
    private static final String LADDER_COLUMN = "|";
    private static final String ALL_PLAYERS = "all";

    private final Output output;

    public LadderOutputView(final Output output) {
        this.output = output;
    }

    public void printLadderResult(final Players players, final Ladder ladder, final Items items) {
        output.printLine("\n사다리 결과\n");

        printPlayers(players);
        printLadder(ladder);
        printItems(items);
    }

    private void printPlayers(final Players players) {
        final String line = players.names()
                .stream()
                .map(name -> String.format(NAME_PRINTING_FORMAT, name))
                .collect(Collectors.joining(NAME_JOIN_DELIMITER));

        output.printLine(line);
    }

    private void printLadder(final Ladder ladder) {
        final String result = ladder.connectionsOfLines()
                .stream()
                .map(this::buildLine)
                .collect(Collectors.joining("\n"));

        output.printLine(result);
    }

    private String buildLine(final List<Boolean> line) {
        final String lineResult = line.stream()
                .map(LADDER_CONNECTION::get)
                .collect(Collectors.joining(LADDER_COLUMN));

        return LADDER_COLUMN + lineResult + LADDER_COLUMN;
    }

    private void printItems(final Items items) {
        final String line = items.names()
                .stream()
                .map(name -> String.format(NAME_PRINTING_FORMAT, name))
                .collect(Collectors.joining(NAME_JOIN_DELIMITER));

        output.printLine(line);
    }

    public void printGameResult(final Result result, final String resultPlayerName) {
        output.printLine("\n실행 결과");

        if (resultPlayerName.equals(ALL_PLAYERS)) {
            final Map<Player, Item> allResult = result.getAll();
            allResult.forEach((player, item) -> output.printLine(format("{0} : {1}", player, item)));

            return;
        }

        output.printLine(result.getOne(resultPlayerName).toString());
    }

    public void printBusinessException(final String message) {
        output.printLine(message);
    }

    public void printUnexpectedException() {
        output.printLine("알 수 없는 에러가 발생했습니다. 프로그램을 종료합니다.");
    }
}
