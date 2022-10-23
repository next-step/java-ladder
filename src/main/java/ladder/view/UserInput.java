package ladder.view;

import java.util.List;
import java.util.Scanner;

import ladder.domain.Height;
import ladder.domain.UserNames;

public class UserInput {
    private final Scanner input;

    public UserInput() {
        input = new Scanner(System.in);
    }

    public UserNames userNames() {
        System.out.println("참여할 사람 이름을 입력하세요.(이름은 쉼표(,)로 구분하세요)");
        return new UserNames(input.next());
    }

    public Height height() {
        System.out.println("최대 사다리 높이는 몇개 인가요?");
        return new Height(input.nextInt());
    }
}
