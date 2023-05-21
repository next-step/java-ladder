package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Result;
import nextstep.ladder.util.RandomUtil;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.*;
import java.util.stream.IntStream;

public class LadderGame {

    private static final String NAME_REX_PATTERN = ",";

    private static final String ALL_PLAYER = "all";

    private Ladder ladder;

    private Result result;

    public static void main(String[] args) {
        LadderGame game = new LadderGame();
        game.run();
    }

    public void run() {

        List<Player> players = new ArrayList<>();

        inputPlayers(players, InputView.inputPlayers());

        result = new Result(InputView.inputResult());

        saveLadder(new Ladder(InputView.inputLadderHeight()));
        addLadderLines(ladder.getHeight(), players.size());

        ResultView.printLadderResult(players, ladder.getLines(), result);

        String inputPlayer = InputView.inputPlayer();
        printPlayerResult(inputPlayer, players);

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

    private void addLadderLines(int height, int width) {
        IntStream.range(0, height)
                .mapToObj(i -> new Line(() -> RandomUtil.generatorPoints(width - 1)))
                .forEach(this::addLine);
    }

    private void addLine(Line line) {
        this.ladder.addLine(line);
    }

    private void printPlayerResult(String inputPlayer, List<Player> players) {

        ResultView.printResultText();

        if (ALL_PLAYER.equals(inputPlayer)) {
            IntStream.range(0, players.size()).forEach(index -> printPlayerResultWithName(index, players.get(index)));
            return;
        }

        int point = players.indexOf(new Player(inputPlayer));
        ResultView.printPlayerResult(result.getValue(players.get(point).getPlayerResultIndex(point, ladder)));

    }

    private void printPlayerResultWithName(int index, Player player) {
        ResultView.printPlayerResultWithName(player.getName(), result.getValue(player.getPlayerResultIndex(index, ladder)));
    }

}
