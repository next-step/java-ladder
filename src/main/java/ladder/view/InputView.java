package ladder.view;

import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static String findGameContributors() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return SCANNER.nextLine();
    }

    public static String findResultList() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)\n");
        return SCANNER.nextLine();
    }

    public static String searchResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return SCANNER.nextLine();
    }
}
