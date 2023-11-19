package nextstep.ladder.input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserNames {
    private final List<String> names;

    public UserNames(final String userNamesText) {
        final String[] splitTexts = userNamesText.split(",");

        this.names = Arrays.stream(splitTexts)
                .filter(name -> name.length() <= 5)
                .collect(Collectors.toUnmodifiableList());

        if (!isSameSize(splitTexts.length)) {
            throw new IllegalArgumentException("이름은 5글자 이하만 가능합니다.");
        }

        if (size() < 2) {
            throw new IllegalArgumentException("이름은 최소 2명 이상이 필요합니다.");
        }
    }

    private boolean isSameSize(final int size) {
        return size() == size;
    }

    public int size() {
        return this.names.size();
    }

    public List<String> names() {
        return this.names;
    }

    @Override
    public String toString() {
        return this.names.toString();
    }
}
