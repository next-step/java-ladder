package nextstep.step4.responsibility.domain;

import java.util.List;

public class UserNames implements UserInputProvider {
    public static final int MIN_SIZE = 2;
    public static final int MAX_NAME_LENGTH = 5;
    private final List<String> names;

    public UserNames(final String nameTexts) {
        final String[] names = nameTexts.split(",");

        validateTexts(names);

        this.names = List.of(names);
    }

    private void validateTexts(final String[] names) {
        if (names.length < MIN_SIZE) {
            throw new IllegalArgumentException("이름은 " + MIN_SIZE + "개 이상이어야 합니다.");
        }

        for (final String name : names) {
            throwExceptionIfNameLengthIsLongerThan5(name);
        }
    }

    private void throwExceptionIfNameLengthIsLongerThan5(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MAX_NAME_LENGTH + "글자까지만 허용합니다.");
        }
    }

    @Override
    public String get(final int index) {
        return this.names.get(index);
    }

    @Override
    public int size() {
        return this.names.size();
    }

    @Override
    public List<String> getList() {
        return this.names;
    }
}
