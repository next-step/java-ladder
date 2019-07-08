package ladder.formatter;

import ladder.domain.Players;

import java.util.stream.Collectors;

public class PlayersPrintFormatter implements DataPrintFormatter<Players> {

    @Override
    public String dataPrintFormat(Players players) {
        return players.getPlayers().stream()
                .map(player -> String.format("%6s", player.getName()))
                .collect(Collectors.joining());
    }
}
