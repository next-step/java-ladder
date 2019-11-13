package game.ladder.view;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

/**
 * Created by yusik on 2019/11/09.
 */
public class InputView {

    private static final int PLAYER_NAME_MAX_LENGTH = 5;
    private static final String DELIMITER = ",";
    private final Scanner scanner;

    public InputView(InputStream in) {
        scanner = new Scanner(in);
    }

    public List<String> receivePlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] players = scanner.nextLine().split(DELIMITER);
        return Arrays.stream(players)
                .map(String::trim)
                .filter(name -> name.length() <= PLAYER_NAME_MAX_LENGTH)
                .collect(toList());
    }

    public int receiveHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String amount = scanner.nextLine();
        return Integer.parseUnsignedInt(amount.trim());
    }

    public List<String> receiveResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String[] results = scanner.nextLine().split(DELIMITER);
        return Arrays.stream(results)
                .map(String::trim)
                .collect(toList());
    }

    public String receiveResultCommand() {
        System.out.println("결과를 보고 싶은 사람은?");
        String command = scanner.nextLine();
        return command.trim();
    }
}
