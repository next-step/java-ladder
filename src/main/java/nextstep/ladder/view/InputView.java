package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PLAYERS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_GAME_RESULTS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_SELECT_PLAYER_GAME_RESULT = "결과를 보고 싶은 사람은? (종료하려면 엔터를 치세요)";
    private static final String NAMES_DELIMITER = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> inputPlayers() {
        print(INPUT_PLAYERS);

        return readAndCollect();
    }

    public static List<String> inputGameResults() {
        print(INPUT_GAME_RESULTS);

        return readAndCollect();
    }

    public static int inputLadderHeight() {
        print(INPUT_LADDER_HEIGHT);

        return getIntValue();
    }

    private static List<String> readAndCollect() {
        return Arrays.stream(readAndSplit())
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static String inputGameResultOfPlayer() {
        print(INPUT_SELECT_PLAYER_GAME_RESULT);

        return SCANNER.nextLine().trim();
    }

    private static String[] readAndSplit() {
        return SCANNER.nextLine().split(NAMES_DELIMITER);
    }

    private static int getIntValue() {
        return Integer.parseInt(SCANNER.nextLine().trim());
    }

    private static void print(String statement) {
        System.out.println(statement);
    }
}
