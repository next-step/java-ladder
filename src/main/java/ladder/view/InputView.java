package ladder.view;

import ladder.model.player.Player;
import ladder.model.player.Players;
import ladder.model.prize.LadderPrize;
import ladder.model.row.Height;
import ladder.util.ScannerUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static ladder.Messages.*;

public class InputView {
    private static final String DELIMITER = ",";
    private static final String ALL = "all";

    public InputView() {
    }

    public Players getPlayers() {
        System.out.println(MESSAGE_INPUT_PLAYERS);
        return Players.create(splitNames(ScannerUtil.readLine()));
    }

    public Height getHeight() {
        System.out.println(MESSAGE_INPUT_LADDER_HEIGHT);
        return new Height(ScannerUtil.readInt());
    }

    public List<LadderPrize> getLadderPrizes() {
        System.out.println(MESSAGE_INPUT_LADDER_RESULT);
        return splitPrizeNames(ScannerUtil.readLine());
    }

    public String getPlayerToGetResult(){
        System.out.println(MESSAGE_INPUT_PLAYER_TO_KNOW_RESULT);
        return ScannerUtil.readLine();
    }

    private List<Player> splitNames(String names) {
        return Arrays.stream(names.split(DELIMITER))
                .map(it -> it.trim())
                .map(it -> new Player(it))
                .collect(Collectors.toList());
    }

    private List<LadderPrize> splitPrizeNames(String prizeNames) {
        return Arrays.stream(prizeNames.split(DELIMITER))
                .map(it -> it.trim())
                .map(it -> new LadderPrize(it))
                .collect(Collectors.toList());
    }
}