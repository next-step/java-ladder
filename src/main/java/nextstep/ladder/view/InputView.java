package nextstep.ladder.view;

import java.util.Scanner;
import nextstep.ladder.domain.Height;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public static String getInputPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요 (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static String getResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static Height getLaddersHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return new Height(Integer.parseInt(scanner.nextLine()));
    }

    public static String getLadderResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }

}
