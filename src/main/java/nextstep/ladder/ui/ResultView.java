package nextstep.ladder.ui;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LADDER_RESULT_COMMENT = "사다리 결과\n";
    private static final String RESULT_USER_NAME_FORMAT = "%5s ";
    private static final String RESULT_PRICE_NAME_FORMAT = "%-5s ";
    private static final String RESULT_LADDER_OPEN = "-----|";
    private static final String RESULT_LADDER_CLOSE = "     |";

    public static void printResult(Users users, Prices prices, Ladder ladder) {
        System.out.println(LADDER_RESULT_COMMENT);

        users.stream()
                .forEach(user -> System.out.print(String.format(RESULT_USER_NAME_FORMAT, user.getName())));

        System.out.print("\n");

        ladder.getLines().stream()
                .forEach(line -> System.out.println(getLineString(line)));

        prices.stream()
                .forEach(price -> System.out.print(String.format(RESULT_PRICE_NAME_FORMAT, price.getMoney())));
    }

    private static String getLineString(Line line) {
        List<String> lineShapes = line.getPoints().stream()
                .map(b -> b ? RESULT_LADDER_OPEN : RESULT_LADDER_CLOSE)
                .collect(Collectors.toList());
        return String.join("", lineShapes);
    }
}
