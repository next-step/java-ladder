package view;

import domain.Ladder;
import domain.Positions;

import java.util.List;

public class ConsoleOutputView {
    public static void printPositions(Positions positions) {
        System.out.println(positions);
    }

    public static void printLadder(Ladder ladder) {
        System.out.println(ladder.toString());
    }

    public static void printAllResult(List<String> users, List<String> results) {
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i) + " : " + results.get(i));
        }
    }

    public static void printOneResult(String user, String result) {
        System.out.println(user + " : " + result);
    }
}
