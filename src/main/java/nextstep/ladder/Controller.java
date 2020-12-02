package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Position;
import nextstep.ladder.domain.Spoke;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.io.OutputStreamWriter;
import java.util.Collections;
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
        List<String> goals = inputView.requestGoal();
        int ladderHeight = inputView.requestHeight();

        Ladder ladder = createLadder(ladderHeight, players.size());
        resultView.printLadder(players, goals, ladder);

        String name;
        do {
            name = inputView.requestPlayerName();
            resultView.printResult(getResultByName(players, goals, ladder, name));
        } while (!name.equals("all"));
    }

    private List<String> getResultByName(List<String> players, List<String> goals, Ladder ladder, String name) {
        if (!name.equals("all")) {
            return Collections.singletonList(getResult(players, goals, ladder, name));
        }

        return players.stream()
                .map(playerName -> playerName + " : " + getResult(players, goals, ladder, playerName))
                .collect(toList());

    }

    private String getResult(List<String> players, List<String> goals, Ladder ladder, String name) {
        return goals.get(ladder.moveOn(Position.of(players.indexOf(name))).toInt());
    }

    private Ladder createLadder(int ladderHeight, int playersCount) {
        return Ladder.of(IntStream.range(0, ladderHeight)
                                 .mapToObj(__ -> Spoke.fromCount(playersCount - 1, RANDOM::nextBoolean)));
    }
}
