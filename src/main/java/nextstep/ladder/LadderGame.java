package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Result;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.*;

public class LadderGame {

    private static final String NAME_REX_PATTERN = ",";

    private static final String ALL_PLAYER = "all";

    public static void main(String[] args) {
        LadderGame game = new LadderGame();
        game.run();
    }

    public void run() {

        List<Player> players = new ArrayList<>();

        inputPlayers(players, InputView.inputPlayers());

        Result result = new Result(InputView.inputResult());
        Ladder ladder = new Ladder(InputView.inputLadderHeight(), players.size());

        ResultView.printLadderResult(players, ladder.getLines(), result);

        String inputPlayer = InputView.inputPlayer();

    }

    private void inputPlayers(List<Player> players, String inputPlayers) {
        addPlayers(players, inputPlayers);
    }

    private void addPlayers(List<Player> players, String inputPlayers) {
        Arrays.stream(inputPlayers.split(NAME_REX_PATTERN))
                .map(Player::new)
                .forEach(players::add);
    }

}
