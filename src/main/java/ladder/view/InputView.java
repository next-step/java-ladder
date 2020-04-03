package ladder.view;

import ladder.model.Height;
import ladder.model.Player;
import ladder.model.Players;
import ladder.util.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static ladder.Messages.MESSAGE_INPUT_LADDER_HEIGHT;
import static ladder.Messages.MESSAGE_INPUT_PLAYERS;

public class InputView {
    private static final String DELIMITER = ",";

    public static Players getPlayers() {
        System.out.println(MESSAGE_INPUT_PLAYERS);
        return Players.create(splitNames(ScannerUtil.readLine()));
    }

    public static Height getHeight() {
        System.out.println(MESSAGE_INPUT_LADDER_HEIGHT);
        return new Height(ScannerUtil.readInt());
    }

    private static List<Player> splitNames(String names) {
        return Arrays.stream(names.split(DELIMITER))
                .map(it -> it.trim())
                .map(it -> new Player(it))
                .collect(Collectors.toList());
    }
}