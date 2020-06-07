package nextstep.ladder.client;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.PlayerPrizes;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGameLauncher {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        new LadderGameLauncher().play();
    }

    private void play() {
        List<Player> players = getPlayers();
        List<String> prizes = inputView.requestPrize();
        int height = inputView.requestHeight();

        Ladder ladder = Ladder.of(height, players.size());

        outputView.printLadder(players, prizes, ladder.getLines());

        PlayerPrizes playerPrizes = ladder.play(players, prizes);
        while (showResult(playerPrizes)) {
        }
    }

    private List<Player> getPlayers() {
        return inputView.requestPlayers().stream()
            .map(Player::new)
            .collect(Collectors.toList());
    }

    private boolean showResult(PlayerPrizes playerPrizes) {

        String playerName = inputView.requestResultOfPlayer();
        boolean isAllUser = Objects.equals(playerName, "all");

        if (isAllUser) {
            outputView.printPlayerPrizes(playerPrizes.getAll());
            return false;
        }

        outputView.printPlayerPrize(playerPrizes.get(new Player(playerName)));
        return true;
    }
}
