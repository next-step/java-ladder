package ladder.view.domain;

import ladder.domain.Player;
import ladder.domain.Players;

public class PlayerView implements DomainPrintable<Players> {
    private static final String NAME_FORMAT_EXPRESSION = "%5s";
    private static final String BLANK_STRING = " ";

    @Override
    public void print(Players players) {
        players.getPlayers()
                .stream()
                .map(Player::name)
                .map(playerName -> formatName(playerName.value()))
                .forEach(System.out::print);
    }

    private static String formatName(String name) {
        return String.format(NAME_FORMAT_EXPRESSION, name) + BLANK_STRING;
    }
}
