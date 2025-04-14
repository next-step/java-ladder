import view.InputView;
import view.ResultView;
import domain.Ladder;
import domain.Player;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameApplication {

    public static void main(String[] args) {
        List<Player> players = InputView.inputPlayers().stream()
                .map(Player::new)
                .collect(Collectors.toList());
        int ladderHeight = InputView.inputLadderHeight();
        Ladder ladder = new Ladder(ladderHeight, players.size());
        ResultView.printResult(players, ladder);
    }
}
