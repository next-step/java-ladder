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
        PlayerNames playerNames = new PlayerNames(
                InputView.getInputNames().stream()
                        .map(PlayerName::new)
                        .collect(Collectors.toList())
        );

        List<String> results = InputView.getResults();
        int height = InputView.getLadderCount();

        Ladder ladder = new Ladder(playerNames.size(), height);
        ResultMapping resultMapping = new ResultMapping(playerNames.getNames(), results);

        OutputView.printNames(playerNames.getNames());
        OutputView.printLine(ladder);
        OutputView.printResults(results);

        runQueryLoop(playerNames, ladder, resultMapping);
    }

    private static void runQueryLoop(PlayerNames playerNames, Ladder ladder, ResultMapping resultMapping) {
        while (true) {
            String input = InputView.askPlayer();
            if (input.equalsIgnoreCase("all")) {
                printAllResults(playerNames, ladder, resultMapping);
                break;
            }

            try {
                PlayerName player = playerNames.findByName(input);
                printSingleResult(player, playerNames, ladder, resultMapping);
            } catch (IllegalArgumentException e) {
                System.out.println("존재하지 않는 참가자입니다: " + input);
            }
        }
    }

    private static void printSingleResult(PlayerName player, PlayerNames playerNames, Ladder ladder, ResultMapping resultMapping) {
        System.out.println("실행 결과");
        try {
            int startIndex = playerNames.indexOf(player);  // 인덱스를 얻고
            String result = LadderGameEngine.move(ladder, startIndex, playerNames.getNames(), resultMapping);
            System.out.println(result);
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("존재하지 않는 참가자입니다: " + player.getName());
        }
    }

    private static void printAllResults(PlayerNames playerNames, Ladder ladder, ResultMapping resultMapping) {
        System.out.println("실행 결과");

        for (PlayerName player : playerNames.getNames()) {
            int startIndex = playerNames.indexOf(player);
            String result = LadderGameEngine.move(ladder, startIndex, playerNames.getNames(), resultMapping);
            System.out.println(player.getName() + " : " + result);
        }
    }
}
