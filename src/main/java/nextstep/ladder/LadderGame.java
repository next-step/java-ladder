package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderGame {

    private static final String NAME_REX_PATTERN = ",";

    private final List<Player> players = new ArrayList<>();

    private Ladder ladder;

    public static void main(String[] args) {
        LadderGame game = new LadderGame();
        game.run();
    }

    public void run() {

        inputPlayers();

        saveLadder(new Ladder(inputLadderHeight(), this.players.size()));

        ResultView.printResult(this.players, ladder.getLines());

    }

    private void inputPlayers() {
        addPlayers(InputView.inputPlayers());
    }

    private void addPlayers(String players) {
        Arrays.stream(players.split(NAME_REX_PATTERN))
                .map(Player::new)
                .forEach(this.players::add);
    }

    private int inputLadderHeight() {
        return InputView.inputLadderHeight();
    }

    private void saveLadder(Ladder ladder) {
        this.ladder = ladder;
    }

}
