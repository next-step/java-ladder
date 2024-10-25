package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderPrizes {
    private final List<LadderPrize> results;

    public LadderPrizes(String inputValue) {
        this.results = convertToResult(inputValue);
    }

    private List<LadderPrize> convertToResult(String inputValue) {
        return Arrays.stream(inputValue.split(","))
                .map(LadderPrize::new)
                .collect(Collectors.toList());
    }

    public List<LadderPrize> getResults() {
        return results;
    }

    public LadderPrize findPrize(int index) {
        return results.get(index);
    }
}
