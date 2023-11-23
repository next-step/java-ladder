package nextstep.step4.domain;

import java.util.List;

public class UserInputTexts {
    private final List<String> texts;

    public UserInputTexts(final String userInputText) {
        final String[] tempTexts = userInputText.split(",");

        validateTexts(tempTexts);

        this.texts = List.of(tempTexts);
    }

    private void validateTexts(final String[] tempNames) {
        for (final String name : tempNames) {
            throwExceptionIfNameLengthIsLongerThan5(name);
        }
    }

    private void throwExceptionIfNameLengthIsLongerThan5(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름 및 실행결과는 5글자까지만 허용합니다.");
        }
    }
}
