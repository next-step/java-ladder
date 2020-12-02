package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Spoke;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Controller {

    private static final Random RANDOM = new Random();
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView(new OutputStreamWriter(System.out));

    public void play() {
        List<String> players = inputView.requestPlayers();
        List<String> goals = inputView.requestGoal();
        int ladderHeight = inputView.requestHeight();

        Ladder ladder = Ladder.of(createSpokes(players, ladderHeight), players, goals);

        resultView.printLadder(ladder);

        String name;
        do {
            name = inputView.requestPlayerName();
            resultView.printResult(getMoveResult(ladder, name));
        } while (!name.equals("all"));
    }

    private Stream<Spoke> createSpokes(List<String> players, int ladderHeight) {
        return IntStream.range(0, ladderHeight)
                .mapToObj(__ -> Spoke.fromCount(players.size() - 1, RANDOM::nextBoolean));
    }

    private Map<String, String> getMoveResult(Ladder ladder, String name) {
        if (name.equals("all")) {
            return ladder.moveForAll();
        }
        Map<String, String> result = new HashMap<>();
        result.put(name, ladder.moveFor(name));
        return result;
    }
}
