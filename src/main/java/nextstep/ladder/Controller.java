package nextstep.ladder;

import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Controller {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView(new OutputStreamWriter(System.out));

    public void play() {
        List<String> players = inputView.requestPlayers();
        int ladderHeight = inputView.requestHeight();

        resultView.printResult(players, IntStream.range(0, ladderHeight)
                .mapToObj(__ -> Spoke.fromCount(players.size() - 1, () -> new Random().nextBoolean()))
                .map(Spoke::toLine)
                .collect(toList()));
    }
}
