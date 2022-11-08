package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final static Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static List<String> readParticipantNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> names = Arrays.asList(SCANNER.nextLine().split(","));
        names.forEach(InputView::checkNameLength);
        return names;
    }

    private static void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 입력할 수 있습니다.");
        }
    }

    public static int readLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(SCANNER.nextLine());
    }

}
