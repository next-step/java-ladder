package ladder.view;

import ladder.model.player.Player;
import ladder.model.prize.LadderPrize;
import ladder.model.row.Height;
import ladder.util.ScannerUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static ladder.Messages.*;

public class InputView {
    private static final String DELIMITER = ",";

    public static List<Player> getPlayersInput() {
        System.out.println(MESSAGE_INPUT_PLAYERS);
        return convertToPlayer(splitNames(ScannerUtil.readLine()));
    }

    public static Height getHeight() {
        System.out.println(MESSAGE_INPUT_LADDER_HEIGHT);
        return new Height(ScannerUtil.readInt());
    }

    public static List<LadderPrize> getLadderPrizesInput() {
        System.out.println(MESSAGE_INPUT_LADDER_RESULT);
        return splitPrizeNames(ScannerUtil.readLine());
    }

    public static String getPlayerToGetResult() {
        System.out.println(MESSAGE_INPUT_PLAYER_TO_KNOW_RESULT);
        return ScannerUtil.readLine();
    }

    private static List<Player> convertToPlayer(List<String> names) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            players.add(new Player(names.get(i)));
        }
        return players;
    }

    private static List<String> splitNames(String names) {
        return Arrays.stream(names.split(DELIMITER))
                .map(it -> it.trim())
                .collect(Collectors.toList());
    }

    private static List<LadderPrize> splitPrizeNames(String prizeNames) {
        return Arrays.stream(prizeNames.split(DELIMITER))
                .map(it -> it.trim())
                .map(it -> new LadderPrize(it))
                .collect(Collectors.toList());
    }
}