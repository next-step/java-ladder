package ladder.view.input;

import ladder.domain.User;
import ladder.util.InputViewUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserNameInputView {
    public static final String DELIMITER = ",";
    public static final int MIN_USERNAME_LENGTH = 1;
    public static final int MAX_USERNAME_LENGTH = 5;

    private List<User> value;

    public UserNameInputView() {
        this(getUserInput());
    }

    public UserNameInputView(List<String> value) {
        validate(value);
        this.value = IntStream.range(0, value.size())
                .mapToObj(i -> new User(value.get(i), i))
                .collect(Collectors.toList());
    }

    private static List<String> getUserInput() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Arrays.stream(InputViewUtil.getUserInputSplitBy(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validate(List<String> value) {
        final boolean invalidNamePresent = value.stream()
                .map(String::length)
                .anyMatch(length -> length < MIN_USERNAME_LENGTH || length > MAX_USERNAME_LENGTH);

        if (invalidNamePresent) {
            throw new IllegalArgumentException();
        }
    }

    public List<User> users() {
        return this.value;
    }

    public int userCount() {
        return this.value.size();
    }

    public User findUser(String target) {
        return this.value.stream()
                .filter(user -> user.name().equals(target))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 유저는 존재하지 않습니다."));
    }

    @Override
    public String toString() {
        return this.value.stream()
                .map(Object::toString)
                .map(InputViewUtil::stringLeftPadding)
                .collect(Collectors.joining(" "));
    }
}
