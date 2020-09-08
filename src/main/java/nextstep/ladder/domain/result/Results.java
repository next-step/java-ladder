package nextstep.ladder.domain.result;

import nextstep.ladder.utils.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Results {

    private List<String> results;

    public Results(String ladderResult) {
        this.results = toList(ladderResult);
    }

    public List<String> toList(String result) {
        return Arrays.asList(spliyByResult(result));
    }

    private static String[] spliyByResult(String result) {
        return StringUtils.splitBy(result);
    }

    public List<String> getResults() {
        return Collections.unmodifiableList(results);
    }
}
