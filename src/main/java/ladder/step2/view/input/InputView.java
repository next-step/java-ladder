package ladder.step2.view.input;

import ladder.step2.domain.Player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static List<Player> inputPlayerNames(String playerNames) {
        playerNames = playerNames.replace(" ", "");
        return Arrays.stream(playerNames.split(","))
                .map(Player::new)
                .collect(Collectors.toList());
    }
}
