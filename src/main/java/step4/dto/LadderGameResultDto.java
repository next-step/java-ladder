package step4.dto;

import java.util.HashMap;
import java.util.Map;

import step4.domain.LadderGameResult;
import step4.domain.Prize;
import step4.domain.UserName;

public class LadderGameResultDto {

    private final Map<String, String> ladderGameResult = new HashMap<>();

    public LadderGameResultDto(Map<String, String> ladderGameResult) {
        this.ladderGameResult.putAll(ladderGameResult);
    }

    public static LadderGameResultDto from(LadderGameResult ladderGameResult) {
        Map<String, String> ladderGameResultDto = new HashMap<>();
        Map<UserName, Prize> ladderGameResultMap = ladderGameResult.getLadderGameResult();
        ladderGameResultMap.keySet()
            .forEach(userName ->
                ladderGameResultDto.put(
                    userName.getUserName(),
                    ladderGameResultMap.get(userName).getPrize()
                )
            );

        return new LadderGameResultDto(ladderGameResultDto);
    }

    public Map<String, String> getLadderGameResult() {
        return ladderGameResult;
    }
}
