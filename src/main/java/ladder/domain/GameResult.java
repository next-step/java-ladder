package ladder.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class GameResult {
    private String gameResult;

    public GameResult(String inputGameResult) {
        gameResult = inputGameResult;
    }
}
