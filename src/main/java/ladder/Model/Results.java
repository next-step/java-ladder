package ladder.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Results {
    private final List<String> results = new ArrayList<>();

    public Results(String input, int size) {
        List<String> parsedInput = Arrays.asList(input.split(","));
        if (parsedInput.size() != size) {
            throw new IllegalArgumentException("결과는 " + size + "개가 입력되어야 합니다. 입력된 결과 개수 : " + parsedInput.size());
        }

        results.addAll(parsedInput);
    }

    public List<String> of() {
        return results;
    }

}
