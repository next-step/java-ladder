package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    private final List<Name> NAMES = Names.of("a,b,c,d");
    private final List<Result> RESULTS = Results.of("some1,some2,some3,some4");
    private final Ladder LADDER = Ladder.of(List.of(
            "|-| | |",
            "| |-| |",
            "| | |-|"),
            '|',
            '-'
    );

    @Test
    @DisplayName("[LadderGame.calculateResultOf] 이름 주면 -> 그 이름의 실행 결과 반환")
    public void getResultTest() {
        LadderGame ladderGame = new LadderGame(NAMES, LADDER, RESULTS);

        assertThat(ladderGame.calculateResultOf(NAMES.get(0)))
                .isEqualTo(RESULTS.get(3));
    }
}
