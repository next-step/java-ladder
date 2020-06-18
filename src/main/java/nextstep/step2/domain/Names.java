package nextstep.step2.domain;

import java.util.Arrays;
import java.util.List;

public class Names {
    private static final int MAX_NAME_LENGTH = 5;
    private List<String> names;

    public Names(String names) {
        String[] nameArray = names.split(",");
        this.names = Arrays.asList(nameArray);
        this.names.forEach(this::validateName);
    }

    public int getParticipantsCount() {
        return names.size();
    }

    public List<String> getNames() {
        return names;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
