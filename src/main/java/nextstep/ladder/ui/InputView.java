package nextstep.ladder.ui;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new UnsupportedOperationException();
    }

    public static List<String> promptNames() {
        System.out.println("참여할 사람 이름을 입력하세요 이름은 쉼표(,)로 구분하세요. ex) pobi,honux,crong,jk");
        return List.of(SCANNER.nextLine().split(",", -1));
    }

    public static int promptHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static List<String> promptPrizes() {
        System.out.println("결과를 입력하세요. 결과는 쉼표(,)로 구분하세요. ex) 꽝,3000,꽝,5000");
        return List.of(SCANNER.nextLine().split(",", -1));
    }

    public static String promptName() {
        System.out.println("결과를 보고 싶은 사람은? 전체를 보려면 all을 입력하세요.");
        return SCANNER.nextLine();
    }
}
