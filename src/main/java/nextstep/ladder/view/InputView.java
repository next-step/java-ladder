package nextstep.ladder.view;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.Results;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.Users;

public class InputView {
    private static final String SPLIT_TEXT = ",";
    private static final String ALL = "all";

    private static InputView inputView = new InputView();
    private Scanner scanner = new Scanner(System.in);

    public Users enterUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String userNames = scanner.nextLine();
        return createUsers(splitByComma(userNames));
    }

    public int enterLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public Results enterResults() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String results = scanner.nextLine();
        return createResults(splitByComma(results));
    }

    public String enterResultUser(Users users) {
        System.out.println("\n결과를 보고 싶은 사람은? ");
        String userName = scanner.next();
        if (ALL.equals(userName)) {
            return userName;
        }

        validateResultUser(users, userName);
        return userName;
    }

    private void validateUserNames(String names) {
        Optional.ofNullable(names)
                .filter(name -> !name.isEmpty())
                .filter(name -> !ALL.equals(name))
                .orElseThrow(() -> new IllegalArgumentException("이름을 빈값이나 all로 입력하였습니다. 이름을 입력해주세요."));
    }

    public String[] splitByComma(String userNames) {
        validateUserNames(userNames);
        return userNames.split(SPLIT_TEXT);
    }

    public Users createUsers(String[] splitUserNames) {
        return new Users(Arrays
                                 .stream(splitUserNames)
                                 .map(User::new)
                                 .collect(Collectors.toList()));
    }

    public Results createResults(String[] splitResults) {
        return new Results(Arrays
                                   .stream(splitResults)
                                   .map(Result::new)
                                   .collect(Collectors.toList()));
    }

    public void validateResultUser(Users users, String userName) {
        Optional.ofNullable(users.getUsers())
                .filter(user -> user.contains(new User(userName)))
                .orElseThrow(() -> new IllegalArgumentException("유저 목록에 해당 이름이 없습니다."));

    }

    public static InputView getInputView() {
        return inputView;
    }

}
