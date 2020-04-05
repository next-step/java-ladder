package ladder.domain.dto;

import java.util.Collections;
import java.util.Map;

public class LadderResultDto {
    private final Map<String, String> resultMap;

    public LadderResultDto(Map<String, String> resultMap) {
        this.resultMap = Collections.unmodifiableMap(resultMap);
    }

    public String getResult(String gamer) {
        return resultMap.get(gamer);
    }
}
