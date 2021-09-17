package nextstep.ladder2;

import nextstep.ladder2.ladder.Ladder;
import nextstep.ladder2.ladder.MakeRealLine;
import nextstep.ladder2.player.Players;
import nextstep.ladder2.result.Results;
import nextstep.ladder2.view.InputView;
import nextstep.ladder2.view.OutputView;

import java.util.Scanner;

public class App {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        InputData data = input();
        playLadderGame(data);
    }

    private static void playLadderGame(InputData data) throws Exception {
        MakeRealLine maker = new MakeRealLine();
        Ladder ladder = new Ladder(maker, data.height(), data.playerSize());

        Players players = data.players();
        Results results = data.results();

        OutputView.viewInit(players, ladder, results);

        ladder.play(players);

        showResult(players, results);
    }

    private static void showResult(Players players, Results results) {
        String name = InputView.inputName(sc);
        while (!"all".equals(name)) {
            OutputView.showResult(players, results, name);
            name = InputView.inputName(sc);
        }
        OutputView.showAllResult(players, results);
    }

    private static InputData input() {
        Players players;
        Results results;
        int height = 0;

        String names = InputView.getName(sc);
        players = Players.of(names);

        String result = InputView.getResults(sc);
        results = Results.of(result);

        height = InputView.getHeight(sc);

        return InputData.of(players, results, height);
    }
}
