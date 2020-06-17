package nextstep.step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ladder {
    private List<String> names;
    private List<Boolean> ladders;

    public Ladder(String names) {
        String[] nameArray = names.split(",");
        this.names = Arrays.asList(nameArray);
        this.names.forEach(this::validateName);
    }

    public Ladder(int inputLadderHeight) {
        ladders = new ArrayList<>();
        for (int i = 0; i < inputLadderHeight; i++) {
            ladders.add(true);
        }
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> getNames() {
        return this.names;
    }

    public List<Boolean> getLadders() {
        return ladders;
    }
}
