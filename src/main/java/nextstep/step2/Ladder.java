package nextstep.step2;

import java.util.Arrays;
import java.util.List;

public class Ladder {
    private List<String> name;

    public Ladder(String names) {
        String[] nameArray = names.split(",");
        this.name = Arrays.asList(nameArray);
        this.name.forEach(this::validateName);
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> getNames() {
        return this.name;
    }
}
