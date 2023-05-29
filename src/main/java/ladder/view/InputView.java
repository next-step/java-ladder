package ladder.view;

import ladder.dto.Player;
import ladder.dto.Players;
import ladder.dto.Results;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final static String QUESTION_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final static String QUESTION_RESULTS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private final static String QUESTION_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private final static String QUESTION_RESULT_OF_PLAYER = "결과를 보고 싶은 사람은?";

    private final static Scanner scanner = new Scanner(System.in);

    private InputView() {
        //
    }

    public static Players getPlayers() {
        System.out.println(QUESTION_PLAYER_NAMES);
        String nameInput = scanner.next();
        System.out.println();

        List<String> names = Arrays.stream(nameInput.split(",")).collect(Collectors.toList());

        return new Players(names);
    }

    public static int getLadderHeight() {
        System.out.println(QUESTION_LADDER_HEIGHT);
        int ladderHeight = scanner.nextInt();
        System.out.println();

        return ladderHeight;
    }

    public static Results getResults(Players players) {
        System.out.println(QUESTION_RESULTS);
        String resultInput = scanner.next();
        System.out.println();

        List<String> results = Arrays.stream(resultInput.split(",")).collect(Collectors.toList());

        return new Results(results, players);
    }

    public static String getResultOfPlayer(Players players) {
        System.out.println(QUESTION_RESULT_OF_PLAYER);
        String playerInput = scanner.next();
        System.out.println();
        validatePlayerInput(playerInput, players);

        return playerInput;
    }

    private static void validatePlayerInput(String playerInput, Players players) {
        if(!"all".equals(playerInput) || !players.hasPlayerName(playerInput)){
            throw new IllegalArgumentException("all 혹은 정확한 플레이어 이름을 입력해주세요.");
        }
    }

}
