package ladder.view;

import ladder.util.InputViewUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserNameInputView {
    public static final String DELIMITER = ",";
    public static final int MIN_USERNAME_LENGTH = 1;
    public static final int MAX_USERNAME_LENGTH = 5;

    private List<String> value;

    public UserNameInputView() {
        this(getUserInput());
    }

    public UserNameInputView(List<String> value) {
        validate(value);
        this.value = value.stream()
                .map(InputViewUtil::stringLeftPadding)
                .collect(Collectors.toList());
    }

    private static List<String> getUserInput() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Arrays.stream(InputViewUtil.getUserInputSplitBy(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validate(List<String> value) {
        value.stream()
                .map(String::length)
                .filter(length -> length >= MIN_USERNAME_LENGTH)
                .filter(length -> length <= MAX_USERNAME_LENGTH)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int userCount() {
        return this.value.size();
    }

    public List<String> userNames() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value.stream()
                .map(String::toString)
                .collect(Collectors.joining(" "));
    }
}
