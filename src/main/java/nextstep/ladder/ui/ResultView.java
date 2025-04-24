package nextstep.ladder.ui;

import nextstep.ladder.GameResult;
import nextstep.ladder.Ladder;
import nextstep.ladder.Player;
import nextstep.ladder.Players;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ResultView {
    public static void viewPerson(Players players) {
        for (Player player : players.getPlayers()) {
            System.out.print(player.getName() + " ");
        }
        System.out.println();
    }

    public static void viewLadder(Ladder ladder, int personOfCount) {
        ladder.getLines().stream()
                .map(line ->
                        IntStream.range(0, personOfCount - 1)
                                .mapToObj(j -> "|" + (line.getPoints().get(j) ? "-----" : "     "))
                                .collect(Collectors.joining()) + "|"
                )
                .forEach(System.out::println);

        String resultLine = ladder.getPrizes().stream()
                .map(prize -> String.format("%-6s", prize.getName()))
                .collect(Collectors.joining());
        System.out.println(resultLine);
    }

    public static void viewGameResult(GameResult gameResult, String input) {
        Stream.of(input)
                .filter("all"::equalsIgnoreCase)
                .findFirst()
                .ifPresentOrElse(
                        v -> printAllResults(gameResult),
                        () -> printSingleResult(gameResult, input)
                );
    }

    private static void printAllResults(GameResult gameResult) {
        gameResult.getAllResults().forEach((player, prize) ->
                System.out.println(player.getName() + " : " + prize.getName())
        );
    }

    private static void printSingleResult(GameResult gameResult, String input) {
        Optional.ofNullable(gameResult.getResult(input))
                .ifPresentOrElse(
                        result -> System.out.println(input + " : " + result),
                        () -> System.out.println("존재하지 않는 참가자입니다.")
                );
    }
}
