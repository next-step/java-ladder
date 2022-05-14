package nextstep.view;

import nextstep.domain.LadderHeight;
import nextstep.domain.LadderResult;
import nextstep.domain.User;
import nextstep.domain.Users;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String COMMA = ",";

    public static Users inputUserName() {
        System.out.println("참여할 사람 이름을 입력하세요, (이름은 쉼표(,)로 구분하세요)");
        return new Users(Arrays.stream(SCANNER.nextLine().split(COMMA))
                .map(User::new)
                .collect(Collectors.toList()));
    }

    public static LadderHeight inputMaxLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        return new LadderHeight(SCANNER.nextInt());
    }

    public static LadderResult inputLadderResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        SCANNER.nextLine();
        return new LadderResult(Arrays.stream(SCANNER.nextLine().split(COMMA))
                .collect(Collectors.toList()));
    }

    public static String inputLadderResultUserName() {
        System.out.println("결과를 보고 싶은 사람은?");
        return SCANNER.nextLine();
    }

}
