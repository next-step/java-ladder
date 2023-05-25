package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultGroup {

    private final List<Result> resultList;

    public ResultGroup(String resultNames) {
        this.resultList = convertToList(resultNames);
    }

    public List<String> getResultNames() {
        return resultList.stream()
                .map(Result::getResultName)
                .collect(Collectors.toList());
    }

    private List<Result> convertToList(String resultList) {
        return Arrays.stream(resultList.split(","))
                .map(result -> new Result(result.trim()))
                .collect(Collectors.toUnmodifiableList());
    }

}
