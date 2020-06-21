package nextstep.ladder.ui;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final String LADDER_RESULT_COMMENT = "사다리 결과\n";
    private static final String RESULT_USER_NAME_FORMAT = "%5s ";
    private static final String RESULT_PRICE_NAME_FORMAT = "%-5s ";
    private static final String RESULT_LADDER_OPEN = "-----|";
    private static final String RESULT_LADDER_CLOSE = "     |";
    private static final String GAME_RESULT_COMMENT = "실행 결과";
    private static final String USER_NAME_AND_PRIZE_FORMAT = "%s : %s";

    public static void printResult(Users users, Prices prices, Ladder ladder) {
        System.out.println(LADDER_RESULT_COMMENT);

        users.stream()
                .forEach(user -> System.out.print(String.format(RESULT_USER_NAME_FORMAT, user.getName())));

        System.out.print("\n");

        ladder.getLines().stream()
                .forEach(line -> System.out.println(getLineString(line)));

        prices.stream()
                .forEach(price -> System.out.print(String.format(RESULT_PRICE_NAME_FORMAT, price.getMoney())));

        System.out.print("\n");
    }

    private static String getLineString(Line line) {
        List<String> lineShapes = line.getPoints().stream()
                .map(b -> b ? RESULT_LADDER_OPEN : RESULT_LADDER_CLOSE)
                .collect(Collectors.toList());
        return String.join("", lineShapes);
    }

    public static void printGameResult(String resultQuery, Users users, Prices resultPrices) {
        System.out.println(GAME_RESULT_COMMENT);

        if (resultQuery.equals("all")) {
            printAllGameResult(users, resultPrices);
            return;
        }

        System.out.println(resultPrices.getPrice(users.getUserIndex(resultQuery)));
    }

    public static void printAllGameResult(Users users, Prices prices) {
        IntStream
                .range(0, users.size())
                .forEach(i -> {
                    System.out.println(String.format(USER_NAME_AND_PRIZE_FORMAT, users.getUser(i).getName(), prices.getPrice(i).getMoney()));
                });
    }
}
