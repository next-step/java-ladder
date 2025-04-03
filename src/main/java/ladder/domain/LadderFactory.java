package ladder.domain;

import java.util.*;

public class LadderFactory {
    private List<String> names;
    private int height;

    public LadderFactory(String namesText, int height) {
        List<String> names = Arrays.asList(namesText.split(","));
        validateNameMaxLength(names);
        validLadderHeight(height);
        this.names = names;
        this.height = height;
    }

    private void validLadderHeight(int height) {
        if(height <= 0)
            throw new IllegalArgumentException("The ladder height should be larger than zero.");
    }

    private void validateNameMaxLength(List<String> names) {
        if (names.stream().anyMatch(name -> name.length() > 5))
            throw new IllegalArgumentException("The name should be up to 5 letters.");

    }

    public List<List<Boolean>> getLadder(LineGenerator generator) {
        List<List<Boolean>> result = new ArrayList<>();
        for (int i=0; i<height; i++) {
            result.add(createLines(generator));
        }
        return result;
    }

    private List<Boolean> createLines(LineGenerator generator) {
        List<Boolean> lines = new ArrayList<>();

        for(int i=0; i<names.size()-1; i++) {
            if(i>0 && lines.get(i-1) != null && lines.get(i-1)) {
                lines.add(false);
                continue;
            }
            boolean connected = generator.isConnected();
            lines.add(connected);

        }
        return lines;
    }

    public List<String> getNames() {
        return Collections.unmodifiableList(names);
    }
}
