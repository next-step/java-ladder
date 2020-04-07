package ladder.view;

import ladder.model.player.Player;
import ladder.model.player.Players;
import ladder.model.prize.LadderPrize;
import ladder.model.prize.LadderPrizes;
import ladder.model.row.Height;
import ladder.model.row.Rows;
import ladder.util.ScannerUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static ladder.Messages.*;

public class InputView {
    private static final String DELIMITER = ",";

    private Players players;
    private Rows rows;
    private LadderPrizes ladderPrizes;

    public InputView() {
    }

    public InputView(Players players, Rows rows, LadderPrizes ladderPrizes) {
        this.players = players;
        this.rows = rows;
        this.ladderPrizes = ladderPrizes;
    }

    public List<Player> getPlayersInput() {
        System.out.println(MESSAGE_INPUT_PLAYERS);
        return convertToPlayer(splitNames(ScannerUtil.readLine()));
    }

    public Height getHeight() {
        System.out.println(MESSAGE_INPUT_LADDER_HEIGHT);
        return new Height(ScannerUtil.readInt());
    }

    public List<LadderPrize> getLadderPrizesInput() {
        System.out.println(MESSAGE_INPUT_LADDER_RESULT);
        return splitPrizeNames(ScannerUtil.readLine());
    }

    public String getPlayerToGetResult() {
        System.out.println(MESSAGE_INPUT_PLAYER_TO_KNOW_RESULT);
        return ScannerUtil.readLine();
    }

    public Players getPlayers() {
        return players;
    }

    public Rows getRows() {
        return rows;
    }

    public LadderPrizes getLadderPrizes() {
        return ladderPrizes;
    }

    public static InputView of(Players players, Rows rows, LadderPrizes ladderPrizes){
        return new InputView(players, rows, ladderPrizes);
    }

    private List<Player> convertToPlayer(List<String> names) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            players.add(new Player(names.get(i), i));
        }
        return players;
    }

    private List<String> splitNames(String names) {
        return Arrays.stream(names.split(DELIMITER))
                .map(it -> it.trim())
                .collect(Collectors.toList());
    }

    private List<LadderPrize> splitPrizeNames(String prizeNames) {
        return Arrays.stream(prizeNames.split(DELIMITER))
                .map(it -> it.trim())
                .map(it -> new LadderPrize(it))
                .collect(Collectors.toList());
    }
}