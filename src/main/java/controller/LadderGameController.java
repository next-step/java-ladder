package controller;

import domain.*;
import strategy.PointsMakeStrategy;
import strategy.RandomPointsMakeStrategy;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LadderGameController {
    private static final InputView INPUT_VIEW = new InputView();

    public static final String TRY_INPUT_AGAIN = " 다시 입력해주세요.";

    public static void main(String[] args) {
        Players players = readPlayers();
        List<String> results = INPUT_VIEW.inputResults(players.size());
        int ladderHeight = INPUT_VIEW.inputLadderHeight();

        Ladder ladder = makeLadder(ladderHeight, players);
        printLadder(players, ladder, results);
        LadderResult ladderResult = ladder.play(players, results);
        printResult(ladderResult);
    }

    private static Players readPlayers() {
        Players players;
        do {
            Optional<Players> validatedInputPlayers = validatedInputPlayers();

            if (validatedInputPlayers.isPresent()) {
                players = validatedInputPlayers.get();
                break;
            }
        } while (true);

        return players;
    }

    private static Optional<Players> validatedInputPlayers() {
        try {
            return Optional.of(Players.fromStringList(INPUT_VIEW.inputPlayers()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + TRY_INPUT_AGAIN);
        }
        return Optional.empty();
    }

    private static void printLadder(Players players, Ladder ladder, List<String> results) {
        OutputView outputView = new OutputView();
        outputView.printPlayers(players);
        outputView.printLadder(ladder);
        outputView.printResults(results);
    }

    private static Ladder makeLadder(int ladderHeight, Players players) {
        PointsMakeStrategy pointsMakeStrategy = new RandomPointsMakeStrategy();
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(Line.from(players.size(), pointsMakeStrategy));
        }
        return Ladder.from(lines);
    }

    private static void printResult(LadderResult ladderResult) {
        while (!recursivePrintResult(ladderResult)) {
        }
    }

    private static boolean recursivePrintResult(LadderResult ladderResult) {
        try {
            OutputView.printGetPlayerResultInputMessage();

            String name = InputView.readNextLine();
            if (OutputView.isGameExitMessage(name)) {
                return true;
            }
            OutputView.printPlayerResult(name, ladderResult);

        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
        return false;
    }
}
