package nextstep.ladder.view;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public final class InputView {
    private InputView() {
    }

    public static List<String> inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().replace(" ", "").split(",");

        return Arrays.asList(names);
    }

    public static List<String> inputResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().replace(" ", "").split(",");

        return Arrays.asList(names);
    }

    public static int inputMaxHeightOfLadder() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        return new Scanner(System.in).nextInt();
    }

    public static String inputResultPlayerName() {
        System.out.println("결과를 보고 싶은 사람은?");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

}
