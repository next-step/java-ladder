package ladder.view.input;

import ladder.util.InputViewUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameResultSettingInputView {
    public static final String DELIMITER = ",";

    private final List<String> value;

    public GameResultSettingInputView(int userCount) {
        this(getUserInput(), userCount);
    }

    public GameResultSettingInputView(List<String> value, int userCount) {
        validate(value, userCount);

        this.value = value;
    }

    public String resultByUserInitPosition(int initPosition) {
        return this.value.get(initPosition);
    }

    private static List<String> getUserInput() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return Arrays.stream(InputViewUtil.getUserInputSplitBy(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validate(List<String> value, int userCount) {
        if (value.size() != userCount) {
            throw new IllegalArgumentException("사용자 인원 수와 결과의 개수가 일치하지 않습니다.");
        }
    }

    @Override
    public String toString() {
        return this.value.stream()
                .map(String::toString)
                .map(InputViewUtil::stringLeftPadding)
                .collect(Collectors.joining(" "));
    }
}
