package nextstep.ladder;

import nextstep.ladder.domain.Spoke;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Controller {

    private static final Random RANDOM = new Random();
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView(new OutputStreamWriter(System.out));

    public void play() {
        List<String> players = inputView.requestPlayers();
        int ladderHeight = inputView.requestHeight();

        resultView.printResult(players, IntStream.range(0, ladderHeight)
                .mapToObj(__ -> Spoke.fromCount(players.size() - 1, RANDOM::nextBoolean))
                .map(Spoke::toLine)
                .collect(toList()));
    }
}
