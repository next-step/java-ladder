import domain.Ladder;
import domain.LadderGameEngine;
import domain.PlayerName;
import domain.PlayerNames;
import view.InputView;
import view.OutputView;
import view.ResultMapping;

import java.util.*;
import java.util.stream.Collectors;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    public static void main(String[] args) {
        LadderGame game = new LadderGame();
        game.run();
    }

    public void run() {
        PlayerNames playerNames = readPlayerNames();
        List<String> results = InputView.getResults();
        int height = InputView.getLadderCount();

        Ladder ladder = new Ladder(playerNames.size(), height);
        ResultMapping resultMapping = new ResultMapping(playerNames.getNames(), results);

        OutputView.printNames(playerNames.getNames());
        OutputView.printLine(ladder);
        OutputView.printResults(results);

        processQueries(playerNames, ladder, resultMapping);
    }

    private PlayerNames readPlayerNames() {
        return new PlayerNames(
                InputView.getInputNames().stream()
                        .map(PlayerName::new)
                        .collect(Collectors.toList())
        );
    }

    private void processQueries(PlayerNames playerNames, Ladder ladder, ResultMapping resultMapping) {
        while (true) {
            String input = InputView.askPlayer();
            if (input.equalsIgnoreCase("all")) {
                printAllResults(playerNames, ladder, resultMapping);
                break;
            }

            printResultForPlayer(input, playerNames, ladder, resultMapping);
        }
    }

    private void printResultForPlayer(String name, PlayerNames playerNames, Ladder ladder, ResultMapping resultMapping) {
        try {
            PlayerName player = playerNames.findByName(name);
            int startIndex = playerNames.indexOf(player);
            String result = LadderGameEngine.move(ladder, startIndex, playerNames.getNames(), resultMapping);
            OutputView.printSingleResult(result);
        } catch (IllegalArgumentException e) {
            OutputView.printError("존재하지 않는 참가자입니다: " + name);
        }
    }

    private void printAllResults(PlayerNames playerNames, Ladder ladder, ResultMapping resultMapping) {
        OutputView.printAllResultsIntro();
        for (PlayerName player : playerNames.getNames()) {
            int startIndex = playerNames.indexOf(player);
            String result = LadderGameEngine.move(ladder, startIndex, playerNames.getNames(), resultMapping);
            OutputView.printResult(player.getName(), result);
        }
    }
}
