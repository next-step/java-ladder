package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderFactory {
    private final List<String> names;
    private final Ladders ladders;

    public LadderFactory(String namesText, int height) {
        this(namesText, height, new RandomLineGenerator());
    }

    public LadderFactory(String namesText, int height, LineGenerator lineGenerator) {
        List<String> names = Arrays.asList(namesText.split(","));
        validateNameMaxLength(names);
        this.names = names;
        this.ladders = new Ladders(height, names.size()-1, lineGenerator);
    }

    private void validateNameMaxLength(List<String> names) {
        if (names.stream().anyMatch(name -> name.length() > 5))
            throw new IllegalArgumentException("The name should be up to 5 letters.");
    }

    public List<List<Boolean>> getLadder() {
        return ladders.get();
    }


    public List<String> getNames() {
        return Collections.unmodifiableList(names);
    }
}
