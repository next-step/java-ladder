package view;

import domain.Ladder;
import domain.LadderGameEngine;
import domain.Line;
import domain.PlayerName;

import java.util.List;

public class OutputView implements Output {

    @Override
    public void printLadder(List<String> playerNames, Ladder ladder, List<String> results) {
        System.out.println();
        System.out.println(String.join("      ", playerNames));
        ladder.getLines().forEach(System.out::println);
        System.out.println(String.join("      ", results));
    }

    @Override
    public void printResult(String playerName, String result) {
        System.out.println(playerName + " : " + result);
    }

    @Override
    public void printAllResult(List<String> allResults) {
        System.out.println("\n실행 결과");
        allResults.forEach(System.out::println);
    }
}
