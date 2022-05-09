package nextstep.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import nextstep.domain.LadderHeight;
import nextstep.domain.User;

public class InputView
{
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String COMMA = ",";

    public static List<User> inputUserName()
    {
        System.out.println("참여할 사람 이름을 입력하세요, (이름은 쉼표(,)로 구분하세요)");
        return Arrays.stream(SCANNER.nextLine().split(COMMA))
            .map(User::new)
            .collect(Collectors.toList());
    }

    public static LadderHeight inputMaxLadderHeight()
    {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        return new LadderHeight(SCANNER.nextInt());
    }

}
