package ladder.controller.response;


import ladder.domain.GameResult;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ResultDto {
    private static final int SINGLE_RESULT_COUNT = 1;

    private final Map<String, String> result;

    private ResultDto(Map<String, String> result) {
        this.result = result;
    }

    public static final ResultDto getInstance(Map<String, String> result) {
        return new ResultDto(result);
    }

    public static final ResultDto getInstance(String name, String result) {
        Map<String, String> tempResult = new LinkedHashMap<>();
        tempResult.put(name, result);

        return new ResultDto(tempResult);
    }

    public static final ResultDto getAllResultInstance(GameResult gameResult) {
        return new ResultDto(gameResult.getGameResult());
    }

    public boolean isSingleResult() {
        return result.size() == SINGLE_RESULT_COUNT;
    }

    public String getSingleResult() {
        return result.entrySet()
                .iterator()
                .next()
                .getValue();
    }

    public Set<String> getNames() {
        return result.keySet();
    }

    public String getResultValue(String name) {
        return result.get(name);
    }
}
