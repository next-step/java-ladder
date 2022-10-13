package step1.dto;

import java.util.HashMap;
import java.util.Map;

import step1.domain.LadderGameResult;
import step1.domain.Prize;
import step1.domain.UserName;

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
