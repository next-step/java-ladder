package nextstep.ladder.domain;

import java.util.List;

public class UserNames {
    public static final int NAME_MAX_LENGTH = 5;
    private static final int MIN_SIZE = 2;
    private final List<String> names;

    public UserNames(final String userNamesText) {
        final String[] splitUserNamesTexts = userNamesText.split(",");

        validateUserNames(splitUserNamesTexts);

        this.names = List.of(splitUserNamesTexts);
    }

    private void validateUserNames(final String[] splitUserNamesTexts) {
        validateUserNamesSize(splitUserNamesTexts);
        validateUserNameLength(splitUserNamesTexts);
    }

    private void validateUserNamesSize(final String[] splitTexts) {
        if (splitTexts.length < MIN_SIZE) {
            throw new IllegalArgumentException("이름은 최소 " + MIN_SIZE + "명 이상이 필요합니다.");
        }
    }

    private void validateUserNameLength(final String[] splitUserNamesTexts) {
        for (final String userName : splitUserNamesTexts) {
            throwExceptionIfUserNameLengthIsOverMaxLength(userName);
        }
    }

    private void throwExceptionIfUserNameLengthIsOverMaxLength(final String userName) {
        if (userName.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 " + NAME_MAX_LENGTH + "글자 이하만 가능합니다.");
        }
    }

    public int size() {
        return this.names.size();
    }

    public List<String> names() {
        return this.names;
    }

    public String get(final int userStartIdx) {
        return this.names.get(userStartIdx);
    }
}
