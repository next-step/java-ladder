package ladder.view;

import ladder.model.Player;
import ladder.util.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static ladder.Messages.MESSAGE_INPUT_LADDER_HEIGHT;
import static ladder.Messages.MESSAGE_INPUT_PLAYERS;

public class InputView {
    private static final String DELIMITER = ",";

    public static List<Player> getPlayers() {
        System.out.println(MESSAGE_INPUT_PLAYERS);
        return splitNames(ScannerUtil.readLine());
    }

    public static int getHeight() {
        System.out.println(MESSAGE_INPUT_LADDER_HEIGHT);
        return ScannerUtil.readInt();
    }

    private static List<Player> splitNames(String names) {
        return Arrays.stream(names.split(DELIMITER))
                .map(it -> it.trim())
                .map(it -> new Player(it))
                .collect(Collectors.toList());
    }
}