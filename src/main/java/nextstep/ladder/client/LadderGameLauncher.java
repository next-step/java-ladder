package nextstep.ladder.client;

import java.util.List;
import java.util.Objects;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.PlayerPrize;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGameLauncher {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        new LadderGameLauncher().play();
    }

    private void play() {
        Ladder ladder = inputLadder();
        outputView.printLadder(ladder);

        while (true) {
            String player = inputView.requestResultOfPlayer();
            boolean isAllUser = Objects.equals(player, "all");

            if (isAllUser) {
                List<PlayerPrize> playerPrizes = ladder.play();
                outputView.printPlayerPrizes(playerPrizes);
                break;
            }

            outputView.printPlayerPrize(ladder.play(Player.of(player)));
        }
    }

    private Ladder inputLadder() {
        List<String> playerNames = inputView.requestPlayers();
        List<String> prizes = inputView.requestPrize();
        int height = inputView.requestHeight();
        return Ladder.of(height, playerNames, prizes);
    }
}
