package ladder.view;

import ladder.domain.Prizes;
import ladder.domain.Players;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final String PLAYERS_DELIMETER = ",";
    private static final String PLAY_RESULTS_DELIMETER = ",";
    private static Scanner scanner = new Scanner(System.in);

    public static Players inputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new Players(Arrays.asList(scanner.next().split(PLAYERS_DELIMETER)));
    }

    public static Prizes inputPlayResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return new Prizes(Arrays.asList(scanner.next().split(PLAY_RESULTS_DELIMETER)));
    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public static String inputPlayerNameForViewResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.next();
    }
}
