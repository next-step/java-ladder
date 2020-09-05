package nextstep.ladder.domain.result;

import nextstep.ladder.utils.StringUtils;

import java.util.Arrays;
import java.util.List;

public class Results {

    private List<String> results;

    private Results(List<String> results) {
        this.results = results;
    }

    public static List<String> from(String result) {
        return Arrays.asList(spliyByResult(result));
    }

    private static String[] spliyByResult(String result) {
        return StringUtils.splitBy(result);
    }
    
}
