package step2.domain;

import step2.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Results {
    private static final String DEFAULT_REGEX = ",";

    private final List<Result> results;

    private Results(List<Result> results) {
        this.results = results;
    }

    public static Results of(String str) {
        validationResult(str);

        String[] resultArr = str.split(DEFAULT_REGEX);
        List<Result> newResults = new ArrayList<>();
        for (String result : resultArr) {
            Result newResult = new Result(result);
            newResults.add(newResult);
        }
        return new Results(newResults);
    }

    private static void validationResult(String str) {
        if (StringUtils.isEmpty(str)) {
            throw new IllegalArgumentException(Result.RESULT_IS_NOT_BLANK_EXCEPTION_MESSAGE);
        }
    }

    public String getResultOfMember(int index) {
        return results.get(index).getResult();
    }

    public List<Result> getResults() {
        return results;
    }
}
