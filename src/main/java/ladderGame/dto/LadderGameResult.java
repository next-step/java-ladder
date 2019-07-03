package ladderGame.dto;

import java.util.List;

public class LadderGameResult {
    private final List<ResultDto> ladderResult;

    public LadderGameResult(List<ResultDto> resultDtos) {
        this.ladderResult = resultDtos;
    }

    public ResultDto getResultSetByName(String name) {
        return ladderResult.stream()
                .filter(result -> result.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("이름이 존재하지 않습니다."));
    }

    public List<ResultDto> getLadderResult() {
        return ladderResult;
    }
}
