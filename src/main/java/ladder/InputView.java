package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static UserNames inputUserName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = SCANNER.next();
        String[] split = input.split(",");

        List<UserName> userNames = Arrays.stream(split)
            .map(UserName::new)
            .collect(Collectors.toList());
        return new UserNames(userNames);
    }

    public static Awards inputGameAwards() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = SCANNER.next();
        String[] split = input.split(",");
        List<Award> awards = Arrays.stream(split)
            .map(Award::new)
            .collect(Collectors.toList());
        return new Awards(awards);
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return SCANNER.nextInt();
    }

    public static UserName inputUserNameResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        String input = SCANNER.next();
        return new UserName(input);
    }
}
