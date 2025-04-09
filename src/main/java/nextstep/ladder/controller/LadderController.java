package nextstep.ladder.controller;

import java.util.stream.IntStream;
import nextstep.ladder.domain.GameResult;
import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.Players;
import nextstep.ladder.view.InputView;

public class LadderController {

    private final Players players;
    private final GameResult gameResult;

    public LadderController(Players players, GameResult gameResult) {
        this.players = players;
        this.gameResult = gameResult;
    }

    public void run() {
        while (true) {
            String input = InputView.getLadderResult();
            if (input.equals("all")) {
                printAllResults();
            } else {
                printSingleResultByName(input);
            }
        }
    }

    private void printAllResults() {
        IntStream.range(0, players.size())
            .forEach(i -> {
                Person player = players.getPlayers().get(i);
                String result = gameResult.finalResult(i);
                System.out.println(player.name() + " : " + result);
            });
    }

    private void printSingleResultByName(String name) {
        players.findPlayerByName(name)
            .map(person -> gameResult.finalResult(person.getStartPosition()))
            .ifPresentOrElse(
                System.out::println,
                () -> System.out.println("없는 이름입니다.")
            );
    }

}
