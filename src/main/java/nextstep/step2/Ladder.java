package nextstep.step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ladder {
    private List<String> names;
    private List<Line> ladders;

    public Ladder(String names, int inputLadderHeight) {
        setNames(names);
        setLadders(inputLadderHeight);
    }

    private void setNames(String names) {
        String[] nameArray = names.split(",");
        this.names = Arrays.asList(nameArray);
        this.names.forEach(this::validateName);
    }

    private void setLadders(int inputLadderHeight) {
        ladders = new ArrayList<>();
        for (int i = 0; i < inputLadderHeight; i++) {
            ladders.add(new Line(names.size()));
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

    public List<Line> getLadders() {
        return ladders;
    }
}
