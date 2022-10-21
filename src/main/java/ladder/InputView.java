package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    public static List<String> inputPersonNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Arrays.stream(scanner.nextLine().split(","))
                .peek(name -> {
                    if (name.length() > 5) {
                        throw new IllegalArgumentException("사람 이름은 최대 5글자 까지 사용할 수 있습니다.");
                    }
                }).collect(Collectors.toList());
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

}
