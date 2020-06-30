package nextstep.ladder.ui;

import nextstep.ladder.domain.prizes.Prizes;
import nextstep.ladder.domain.users.Users;
import nextstep.ladder.domain.result.UsersPrize;
import nextstep.ladder.common.Direction;
import nextstep.ladder.domain.ladders.Ladder;
import nextstep.ladder.domain.ladders.Line;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LADDER_RESULT_COMMENT = "사다리 결과\n";
    private static final String RESULT_USER_NAME_FORMAT = "%5s ";
    private static final String RESULT_PRICE_NAME_FORMAT = "%-5s ";
    private static final String RESULT_LADDER_OPEN = "-----|";
    private static final String RESULT_LADDER_CLOSE = "     |";
    private static final String GAME_RESULT_COMMENT = "실행 결과";
    private static final String USER_NAME_AND_PRIZE_FORMAT = "%s : %s";

    public static void printResult(Users users, Prizes prizes, Ladder ladder) {
        System.out.println(LADDER_RESULT_COMMENT);

        users.stream()
                .forEach(user -> System.out.print(String.format(RESULT_USER_NAME_FORMAT, user.getName())));

        System.out.print("\n");

        ladder.getLines().stream()
                .forEach(line -> System.out.println(getLineString(line)));

        prizes.stream()
                .forEach(price -> System.out.print(String.format(RESULT_PRICE_NAME_FORMAT, price.getPrize())));

        System.out.print("\n");
    }

    private static String getLineString(Line line) {
        List<String> lineShapes = line.getDirections().stream()
                .map(d -> d == Direction.LEFT ? RESULT_LADDER_OPEN : RESULT_LADDER_CLOSE)
                .collect(Collectors.toList());
        return String.join("", lineShapes);
    }

    public static boolean printGameResult(String resultQuery, UsersPrize usersPrize) {
        System.out.println(GAME_RESULT_COMMENT);

        if (resultQuery.equals("all")) {
            printAllGameResult(usersPrize);
            return true;
        }

        System.out.println(usersPrize.getPrize(resultQuery));
        return false;
    }

    public static void printAllGameResult(UsersPrize usersPrize) {
        usersPrize.getPrizeMap()
                .entrySet()
                .forEach(e ->
                        System.out.println(String.format(USER_NAME_AND_PRIZE_FORMAT, e.getKey(), e.getValue().getPrize()))
                );
    }
}
