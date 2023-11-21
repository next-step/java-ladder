package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public final class InputView {
    private InputView() {
    }

    public static List<String> inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().trim().split(",");

        return Arrays.asList(names);
    }

    public static int inputMaxHeightOfLadder() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        return new Scanner(System.in).nextInt();
    }
}
