package view;

import domain.Ladder;

import java.util.List;

public interface Output {
    void printLadder(List<String> playerNames, Ladder ladder, List<String> results);
    void printResult(String playerName, String result);
    void printAllResult(List<String> allResults);
}