package nextstep.ladder.view;

import nextstep.ladder.domain.User;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String DELIMETER = ",";
    private final Scanner scanner = new Scanner(System.in);

    public List<User> inputUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.");
        return Arrays.stream(scanner.nextLine().split(DELIMETER))
                .map(User::new)
                .collect(Collectors.toList());
    }

    public int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return toInt(scanner.nextLine());
    }

    private int toInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리 높이는 숫자 형식이여야 합니다");
        }
    }

}
