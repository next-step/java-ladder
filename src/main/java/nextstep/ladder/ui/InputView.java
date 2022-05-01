package nextstep.ladder.ui;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    public static List<Integer> promptMoneys() {
        System.out.println("상금을 입력하세요.꽝은 0원입니다. 상금은 쉼표(,)로 구분하세요. ex) 꽝,3000,꽝,5000");
        List<String> moneys = List.of(SCANNER.nextLine().split(",", -1));
        
        return moneys.stream()
                .map(InputView::toInt)
                .collect(Collectors.toList());
    }

    private static int toInt(String money) {
        if (money.equals("꽝")) {
            return 0;
        }
        return Integer.parseInt(money);
    }

    public static String promptName() {
        System.out.println("결과를 보고 싶은 사람은? 전체를 보려면 all을 입력하세요.");
        return SCANNER.nextLine();
    }
}
