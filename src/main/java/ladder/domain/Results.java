package ladder.domain;

import spark.utils.StringUtils;

import java.util.List;

public class Results {
    private static final String LINE_SEPARATOR = "line.separator";
    private static final String ALL_RESULT = "all";
    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public Result findResult(String name) {
        return (results.stream().filter(result -> result.isNameEqual(name)).findFirst())
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자를 찾을 수 없습니다."));
    }

    public String getResult(String condition) {
        if(StringUtils.isEmpty(condition)) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        if(condition.equals(ALL_RESULT)) {
            return toString();
        }
        return findResult(condition).getWinning().trim();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Result result : results) {
            stringBuffer.append(result.toString().trim());
            stringBuffer.append(System.getProperty(LINE_SEPARATOR));
        }

        return stringBuffer.toString();
    }
}
