package laddergame.controller;

import laddergame.component.LadderFactory;
import laddergame.domain.Direction;
import laddergame.domain.LadderLine;
import laddergame.dto.LadderDto;
import laddergame.dto.LadderGameResult;
import laddergame.dto.LadderGameRunRequest;
import laddergame.dto.LadderLineDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameRunnerTest {

    private final LadderFactory ladderFactory = new LadderFactory(numberOfColumns -> LadderLine.from(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT));
    private final LadderGameRunner ladderGameRunner = new LadderGameRunner(ladderFactory);

    @DisplayName("참가자 이름 목록과 사다리 높이를 전달하면, 사다리 게임 결과를 반환해야 한다.")
    @Test
    void run() {
        LadderGameRunRequest request = new LadderGameRunRequest(
                List.of("a", "ab", "abc", "abcd"),
                List.of("꽝", "꽝", "1000", "500"),
                3
        );
        assertThat(ladderGameRunner.run(request)).isEqualTo(
                new LadderGameResult(
                        new LadderDto(List.of(
                                new LadderLineDto(List.of(true, false, true)),
                                new LadderLineDto(List.of(true, false, true)),
                                new LadderLineDto(List.of(true, false, true))
                        )),
                        Map.of("a", "꽝", "ab", "꽝", "abc", "500", "abcd", "1000")
                )
        );
    }

}
