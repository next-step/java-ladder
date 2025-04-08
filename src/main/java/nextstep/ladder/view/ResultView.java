package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.function.Function;


public class ResultView {

    public static void printResult(GameEntities gameEntities, Ladder ladder) {
        System.out.println("실행결과");
        printEntities(gameEntities.getParticipants(), Participant::getName);
        printLadder(ladder);
        printEntities(gameEntities.getRewards(), Reward::getReward);
    }

    private static <T> void printEntities(List<T> entities, Function<T, String> formatter) {
        entities
                .stream()
                .map(formatter)
                .forEach(ResultView::printFormattedName);
        System.out.println();
    }

    private static void printFormattedName(String name) {
        System.out.print(" ".repeat(6 - name.length()) + name);
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLines()
                .forEach(ResultView::printLine);
    }

    private static void printLine(Line line) {
        System.out.print(" ".repeat(5) + "|");
        line.getPoints()
                .stream().map(Point::isPresent)
                .forEach(ResultView::printPoint);
        System.out.println();
    }

    private static void printPoint(boolean isPresent) {
        System.out.print((isPresent ? "-" : " ").repeat(5));
        System.out.print("|");
    }

    public static void printReward(Reward reward) {
        System.out.println(reward.getReward());
    }

    public static void printAllResult(LadderGameResults ladderGameResults) {
        ladderGameResults.forEach(ladderGameResult ->
                System.out.println(ladderGameResult.getParticipant().getName() + " : " + ladderGameResult.getReward().getReward()));
    }
}
