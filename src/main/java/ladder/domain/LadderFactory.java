package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public List<List<Boolean>> getLadder() {
        List<List<Boolean>> result = new ArrayList<>();
        for (int i=0; i<height; i++) {
            result.add(new ArrayList<>());
            for(int j=0; j<names.size()-1; j++) {
                result.get(i).add(true);
            }
        }
        return result;
    }
}
