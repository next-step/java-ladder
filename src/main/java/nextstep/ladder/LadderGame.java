package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Result;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.*;
import java.util.stream.IntStream;

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
//        addLadderLines(ladder.getHeight(), players.size());

        ResultView.printLadderResult(players, ladder.getLines(), result);

        String inputPlayer = InputView.inputPlayer();
        printPlayerResult(result, inputPlayer, players, ladder);

    }

    private void inputPlayers(List<Player> players, String inputPlayers) {
        addPlayers(players, inputPlayers);
    }

    private void addPlayers(List<Player> players, String inputPlayers) {
        Arrays.stream(inputPlayers.split(NAME_REX_PATTERN))
                .map(Player::new)
                .forEach(players::add);
    }
    private void printPlayerResult(Result result, String inputPlayer, List<Player> players, Ladder ladder) {
        if (ALL_PLAYER.equals(inputPlayer)) {
            IntStream.range(0, players.size()).forEach(index -> printPlayerResultWithName(result, index, players.get(index), ladder));
            return;
        }

        int point = players.indexOf(new Player(inputPlayer));
        ResultView.printPlayerResult(result.getValue(ladder.getPlayerResultIndex(point)));

    }

    private void printPlayerResultWithName(Result result, int index, Player player, Ladder ladder) {
        ResultView.printPlayerResultWithName(player.getName(), result.getValue(ladder.getPlayerResultIndex(index)));
    }

}
