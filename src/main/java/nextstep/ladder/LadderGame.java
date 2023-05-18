package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Result;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderGame {

    private static final String NAME_REX_PATTERN = ",";

    private Ladder ladder;

    public static void main(String[] args) {
        LadderGame game = new LadderGame();
        game.run();
    }

    public void run() {

        List<Player> players = new ArrayList<>();

        inputPlayers(players, InputView.inputPlayers());

        Result result = new Result(InputView.inputResult());

        saveLadder(new Ladder(InputView.inputLadderHeight(), players.size()));

        ResultView.printResult(players, ladder.getLines(), result);

    }

    private void inputPlayers(List<Player> players, String inputPlayers) {
        addPlayers(players, inputPlayers);
    }

    private void addPlayers(List<Player> players, String inputPlayers) {
        Arrays.stream(inputPlayers.split(NAME_REX_PATTERN))
                .map(Player::new)
                .forEach(players::add);
    }

    private void saveLadder(Ladder ladder) {
        this.ladder = ladder;
    }

}
