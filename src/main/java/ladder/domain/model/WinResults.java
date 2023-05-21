package ladder.domain.model;

import java.util.List;

public class WinResults {
    private List<WinResult> winResults;

    public WinResults(List<WinResult> winResults) {
        this.winResults = winResults;
    }

    public void validateCounts(int playCount) {
        if (playCount != winResults.size()) {
            throw new IllegalArgumentException("당첨 결과와 인원수가 맞지 않습니다.");
        }
    }
}
