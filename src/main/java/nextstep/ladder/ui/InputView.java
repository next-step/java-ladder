package nextstep.ladder.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> readParticipantNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉽표(,)로 구분하세요)");
        return parseStringList(nextLine());
    }

    private static String nextLine() {
        return SCANNER.nextLine();
    }

    private static List<String> parseStringList(String string) {
        String[] strings = string.replace(" ", "").split(",");
        return Arrays.stream(strings).collect(Collectors.toUnmodifiableList());
    }

    public static int readLadderMaxHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return nextInt();
    }

    private static int nextInt() {
        return SCANNER.nextInt();
    }

}
