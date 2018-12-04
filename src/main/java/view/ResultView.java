package view;

import domain.Ladder;
import domain.LadderReward;
import domain.Line;
import domain.Players;

import java.util.Arrays;
import java.util.stream.IntStream;

public abstract class ResultView {

    private ResultView() {
    }

    public static void printPlayers(final Players players) {
        newLine();
        System.out.println(players.toString());
    }

    public static void printLadder(final Ladder ladder) {
        final String[] results = new String[ladder.getCountOfPlayer()];
        initializeResultArray(ladder, results);
        calculatorLadderPoint(ladder, results);
        printResult(results);
    }

    private static void calculatorLadderPoint(final Ladder ladder, final String[] results) {
        IntStream.range(0, ladder.getLines().size()).forEach(i -> loopLinePoint(results, ladder.getLines().get(i)));
    }

    private static void loopLinePoint(final String[] results, final Line line) {
        IntStream.range(0, line.getPoints().size()).forEach(j -> results[j] += line.isExistence(j) ? "|-----" : "|     ");
    }

    private static void printResult(final String[] results) {
        Arrays.stream(results).forEach(System.out::println);
    }

    private static void initializeResultArray(final Ladder ladder, final String[] results) {
        IntStream.range(0, ladder.getCountOfPlayer()).forEach(i -> results[i] = "");
    }

    private static void newLine() {
        System.out.println();
    }

    public static void printRewards(final LadderReward reward) {
        System.out.println(reward.toString());
    }
}
