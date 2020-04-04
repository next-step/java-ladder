package nextstep.ladder;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String SPLIT_TEXT = ",";

    private static InputView inputView = new InputView();
    private Scanner scanner = new Scanner(System.in);

    public Users enterUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String userNames = scanner.nextLine();
        return createUsers(splitUserNames(userNames));
    }

    public int enterLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public void validateUserNames(String names) {
        Optional.ofNullable(names)
                .filter(name -> !name.isEmpty())
                .orElseThrow(() -> new IllegalArgumentException("이름을 빈값으로 입력하였습니다. 이름을 입력해주세요."));
    }

    public String[] splitUserNames(String userNames) {
        validateUserNames(userNames);
        return userNames.split(SPLIT_TEXT);
    }

    public Users createUsers(String[] splitUserNames) {
        return new Users(Arrays
                                 .stream(splitUserNames)
                                 .map(User::new)
                                 .collect(Collectors.toList()));
    }

    public static InputView getInputView() {
        return inputView;
    }
}
