package nextstep.ladder;

import java.util.Optional;

public class InputView {
    private static final String SPLIT_TEXT = ",";

    public void validateUserNames(String names) {
        Optional.ofNullable(names)
                .filter(name -> !name.isEmpty())
                .orElseThrow(() -> new IllegalArgumentException("이름을 빈값으로 입력하였습니다. 이름을 입력해주세요."));
    }

    public String[] splitUserNames(String userNames) {
        validateUserNames(userNames);
        return userNames.split(SPLIT_TEXT);
    }
}
