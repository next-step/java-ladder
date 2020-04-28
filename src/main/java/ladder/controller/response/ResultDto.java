package ladder.controller.response;


import ladder.service.type.GameResult;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ResultDto {
    private Map<String, String> result;

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

    public Set<String> getNames() {
        return result.keySet();
    }
}
