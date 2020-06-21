package nextstep.ladder.ui;

import nextstep.ladder.domain.Price;
import nextstep.ladder.domain.Prices;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.Users;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_USER_LINE_COMMENT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT_COMMENT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_PRICE_COMMENT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_RESULT_QUERY_COMMENT = "결과를 보고 싶은 사람은?";
    private static final String USER_DELIMITER = ",";
    private static final String PRICE_DELIMITER = ",";

    private static final Scanner scanner = new Scanner(System.in);

    public static Users insertUserLine() {
        System.out.println(INPUT_USER_LINE_COMMENT);
        String userLineString = scanner.nextLine();
        return new Users(
                Arrays.stream(userLineString.split(USER_DELIMITER))
                        .map(User::new)
                        .collect(Collectors.toList())
        );
    }

    public static int getHeight() {
        System.out.println(INPUT_HEIGHT_COMMENT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static Prices getPrices() {
        System.out.println(INPUT_PRICE_COMMENT);
        String priceString = scanner.nextLine();
        return new Prices(
                Arrays.stream(priceString.split(PRICE_DELIMITER))
                .map(Price::new)
                .collect(Collectors.toList())
        );
    }

    public static String getResultQuery() {
        System.out.println(INPUT_PRICE_COMMENT);
        return scanner.nextLine();
    }
}
