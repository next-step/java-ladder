package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LadderTest {
    @Test
    void create() {
        assertAll(
                () -> {
                    assertThatThrownBy(() -> new Ladder(-1, Collections.emptyList()))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("음수는 입력할 수 없습니다.");
                },
                () -> {
                    assertDoesNotThrow(() -> new Ladder(4, List.of("kim","kwon","lee")));
                }
        );

    }

    @Test
    void print() {
        Ladder ladder = getLadder();
        assertThat(ladder.print()).isEqualTo(
                "|-----|     |-----|     |\n" +
                        "|     |-----|     |-----|\n" +
                        "|-----|     |-----|     |\n" +
                        "|     |-----|     |-----|\n"
        );
    }

    @DisplayName("getResult는 특정 참여자에 대한 결과를 알려준다.")
    @ParameterizedTest
    @CsvSource(
            value = {
                    "kim | 4",
                    "kwon | 2",
                    "lee | 3",
                    "choi | 0",
                    "park | 1"
            }
    , delimiterString = "|")
    void getResultPosition(String name, int expectedResult) {
        Ladder ladder = getLadder();
        assertThat(ladder.getResultPosition(name)).isEqualTo(expectedResult);
    }

    private static Ladder getLadder() {
        LadderRow[] ladderRows = new LadderRow[]{
                new LadderRow(new Boolean[]{true, false, true, false}),
                new LadderRow(new Boolean[]{false, true, false, true}),
                new LadderRow(new Boolean[]{true, false, true, false}),
                new LadderRow(new Boolean[]{false, true, false, true})
        };

        Ladder ladder = new Ladder(ladderRows, List.of("kim","kwon","lee","choi","park"));
        return ladder;
    }
}
