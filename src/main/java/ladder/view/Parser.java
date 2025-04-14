package ladder.view;

import ladder.domain.Player;
import ladder.domain.Result;

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

    public static List<Result> parseStringToResult(String input) {
        return Arrays.stream(input.trim().split(","))
                .map(String::trim)
                .filter(token -> !token.isEmpty())
                .map(Result::new)
                .collect(Collectors.toList());
    }
}
