package ladder.view;

import ladder.domain.ladder.Direction;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.Point;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.product.Products;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String PRINT_LADDER_WIDTH = "-";
    private static final String PRINT_LADDER_HEIGHT = "|";
    private static final int PRINT_DEFAULT_NAME_SPACE = 6;
    private static final int PRINT_LADDER_REPEAT = 5;

    private ResultView() {

    }

    public static void printUserNames(Players players) {
        players.getPlayers()
                .stream()
                .map(Player::getName)
                .forEach(name -> {
                    System.out.print(repeatWord(" ", PRINT_DEFAULT_NAME_SPACE - name.length()) + name);
                });
        System.out.println();
    }

    public static void printLines(List<Line> lines) {
        lines.forEach(line -> {
            printPoint(line);
            System.out.println();
        });
    }

    public static void printProducts(Products products) {
        products.getProducts()
                .forEach(product -> {
                    System.out.print(product + repeatWord(" ", PRINT_DEFAULT_NAME_SPACE - product.length()));
                });
        System.out.println();
    }

    public static void printLadderResult(Players players, Products products, List<Line> lines) {
        System.out.println("\n실행결과\n");
        printUserNames(players);
        printLines(lines);
        printProducts(products);
    }

    public static void printPoint(Line line) {
        line.getPoints().stream()
                .map(Point::getDirection)
                .map(Direction::isLeft)
                .forEach(aBoolean -> {
                    System.out.print(repeatWord(aBoolean ? PRINT_LADDER_WIDTH : " ", PRINT_LADDER_REPEAT));
                    System.out.print(PRINT_LADDER_HEIGHT);
                });
    }

    private static String repeatWord(String word, int repeat) {
        StringBuilder result = new StringBuilder();
        for ( int i = 0; i < repeat; i++ ) {
            result.append(word);
        }
        return result.toString();
    }

    private static void printPlayerResult(String playerName, String product) {
        System.out.printf("%s : %s\n", playerName, product);
    }

    private static List<String> getPlayerName(String playerName, Players players) {
        if ("all".equals(playerName.toLowerCase())) {
            return players.getPlayers()
                    .stream()
                    .map(Player::getName)
                    .collect(Collectors.toList());
        }
        return Collections.singletonList(playerName);
    }

    public static void printResult(Players players, Products products, Ladder ladder) {
        String playerName = "";
        while (!"all".equals(playerName.toLowerCase())) {
            playerName = InputView.inputResult();
            List<String> resultPlayerName = getPlayerName(playerName, players);
            System.out.println("실행 결과");
            resultPlayerName.forEach(name -> {
                printPlayerResult(name, products.getProductByIndex(
                        ladder.getResultIndexByPlayerIndex(players.getIndexByName(name))
                ));
            });
        }
    }
}
