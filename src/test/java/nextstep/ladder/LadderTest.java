package nextstep.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        int sizeOfPlayer = 4;
        int ladderHeight = 5;
        ladder = Ladder.of(sizeOfPlayer, ladderHeight, () -> TRUE);
    }

    @Test
    @DisplayName(value = "사다리 생성")
    void init() {
        List<LadderLine> ladderLines = new ArrayList<LadderLine>(){
            {
                add(LadderLine.init(4, () -> TRUE));
                add(LadderLine.init(4, () -> TRUE));
                add(LadderLine.init(4, () -> TRUE));
                add(LadderLine.init(4, () -> TRUE));
                add(LadderLine.init(4, () -> TRUE));
            }
        };

        assertThat(ladder.ladderLines())
                .isEqualTo(ladderLines);
    }

    @ParameterizedTest
    @DisplayName(value = "사다리 마지막 결과 포지션")
    @CsvSource(value = {"0:1", "1:0", "2:3", "3:2"}, delimiter = ':')
    void result_position(int startPosition, int resultPosition) {
        assertThat(ladder.lastLadderPosition(startPosition))
                .isEqualTo(resultPosition);
    }
}
