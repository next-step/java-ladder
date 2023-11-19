package nextstep.ladder.input;

import java.util.Arrays;
import java.util.List;

public class UserNames {
    private final List<String> names;

    public UserNames(final String userNamesText) {
        final String[] splitTexts = userNamesText.split(",");

        this.names = Arrays.asList(splitTexts);
    }

    public List<String> getNames() {
        return this.names;
    }

    @Override
    public String toString() {
        return this.names.toString();
    }
}
