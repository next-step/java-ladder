package nextstep.step4.domain;

import java.util.List;

public class UserInputTexts {
    public static final int MIN_SIZE = 2;
    public static final int MAX_TEXT_LENGTH = 5;
    private final List<String> texts;

    public UserInputTexts(final String userInputText) {
        final String[] tempTexts = userInputText.split(",");

        validateTexts(tempTexts);

        this.texts = List.of(tempTexts);
    }

    private void validateTexts(final String[] tempNames) {
        if (tempNames.length < MIN_SIZE) {
            throw new IllegalArgumentException("이름 및 실행결과는 " + MIN_SIZE + "개 이상이어야 합니다.");
        }

        for (final String name : tempNames) {
            throwExceptionIfNameLengthIsLongerThan5(name);
        }
    }

    private void throwExceptionIfNameLengthIsLongerThan5(final String name) {
        if (name.length() > MAX_TEXT_LENGTH) {
            throw new IllegalArgumentException("이름 및 실행결과는 " + MAX_TEXT_LENGTH + "글자까지만 허용합니다.");
        }
    }

    public int size() {
        return this.texts.size();
    }

    public List<String> getTexts() {
        return texts;
    }
}
