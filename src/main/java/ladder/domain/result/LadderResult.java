package ladder.domain.result;

import ladder.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResult {

    private final List<String> results;

    private LadderResult(List<String> results) {
        this.results = results;
    }

    public static LadderResult of(String input) {
        StringUtils.validate(input);
        return new LadderResult(Arrays
                .stream(StringUtils.getNamesFrom(input))
                .collect(Collectors.toList()));
    }

    public String get(int index) {
        return results.get(index);
    }

    public int size() {
        return results.size();
    }
}
