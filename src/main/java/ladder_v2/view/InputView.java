package ladder_v2.view;

import ladder.domain.Height;
import ladder_v2.domain.Name;
import ladder_v2.domain.Players;
import ladder_v2.domain.Rewards;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_REWARDS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String QUESTION_RESULT = "결과를 보고 싶은 사람은?";

    public static Players inputNames() {
        System.out.println(INPUT_NAMES);
        return new Players(Arrays.stream(SCANNER.nextLine().split(","))
                .map(String::trim)
                .map(Name::new)
                .collect(Collectors.toList()));
    }

    public static Height inputHeight() {
        System.out.println(INPUT_HEIGHT);
        return new Height(SCANNER.nextInt());
    }

    public static Rewards inputRewards() {
        System.out.println();
        System.out.println(INPUT_REWARDS);
        return new Rewards(Arrays.stream(SCANNER.nextLine().split(","))
                .map(String::trim)
                .collect(Collectors.toList()));
    }

    public static Name inputResult() {
        System.out.println();
        System.out.println(QUESTION_RESULT);
        SCANNER.nextLine();
        return new Name(SCANNER.nextLine());
    }
}
