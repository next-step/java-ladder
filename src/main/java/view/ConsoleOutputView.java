package view;

import domain.Ladder;
import domain.LadderGame;
import domain.User;

import java.util.List;

public class ConsoleOutputView {
    public static void printResult(LadderGame ladderGame) {
        printUsers(ladderGame.getUsers());
        printLadder(ladderGame.getLadder());
    }

    private static void printUsers(List<User> users) {
        users.forEach(System.out::print);
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        System.out.println(ladder.toString());
    }
}
