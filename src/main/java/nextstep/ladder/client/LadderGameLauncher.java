package nextstep.ladder.client;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderGameLauncher {

    private static final String ALL_PLAYERS = "all";

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
        LadderResult result = ladder.moveLines();

        showResult(new LadderResultMapper(result, players, prizes));
    }

    private void showResult(LadderResultMapper playerPrizesMapper) {
        while (true) {
            String playerName = inputView.requestResultOfPlayer();
            boolean isAllUser = Objects.equals(playerName, ALL_PLAYERS);

            if (isAllUser) {
                outputView.printPlayerPrizes(playerPrizesMapper.getPlayerPrizes());
                break;
            }

            outputView.printPlayerPrize(playerPrizesMapper.getPrize(playerName));
        }
    }

    private List<Player> getPlayers() {
        return inputView.requestPlayers().stream()
            .map(Player::new)
            .collect(Collectors.toList());
    }
}
