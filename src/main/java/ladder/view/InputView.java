package ladder.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static List<String> getPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return List.of(SCANNER.nextLine().split(DELIMITER));
    }

    public static int getLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(SCANNER.nextLine());
    }


    public static List<String> getPrizeNames() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return List.of(SCANNER.nextLine().split(DELIMITER));
    }

    public static String getPlayerNameForResult() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        return SCANNER.nextLine();
    }
}
