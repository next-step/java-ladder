package ladder.view;

import ladder.domain.Player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    private Parser() {
    }

    public static List<Player> parseStringToPlayer(String input) {
        return Arrays.stream(input.trim().split(","))
                .map(String::trim)
                .filter(token -> !token.isEmpty())
                .map(Player::new)
                .distinct()
                .collect(Collectors.toList());
    }
}
