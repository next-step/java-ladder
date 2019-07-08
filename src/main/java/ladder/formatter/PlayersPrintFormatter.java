package ladder.formatter;

import ladder.domain.Player;
import ladder.domain.Players;

import java.util.stream.Collectors;

public class PlayersPrintFormatter implements DataPrintFormatter<Players> {

    private final NameFormatter<Player> playerNameFormatter = new PlayerNameFormatter();

    @Override
    public String dataPrintFormat(Players players) {
        return players.getPlayers().stream()
                .map(player -> String.format(playerNameFormatter.nameFormat(player), player.getName()))
                .collect(Collectors.joining());
    }
}
