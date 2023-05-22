package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderRowTest {

    LadderRow ladderRow = new LadderRow(
            new Boolean[]{
                    true, false, true, false
            }
    );

    @Test
    void print() {
        assertThat(ladderRow.print())
                .isEqualTo("|-----|     |-----|     |");
    }

    @Test
    void size() {
        assertThat(ladderRow.size()).isEqualTo(4);
    }

    @ParameterizedTest
    @DisplayName("move는 사다리 연결 상태를 확인하고, 이동된 위치를 반환한다.")
    @CsvSource(value = {
            "0 | 1",
            "1 | 0",
            "2 | 3",
            "3 | 2",
            "4 | 4"
    }, delimiterString = "|")
    void move(int currentPoint, int expectedResult) {
        assertThat(ladderRow.move(currentPoint)).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("AlwaysConnectStrategy 전략을 적용하면, 연속적인 선은 제외하고 모든 사다리를 잇는다.")
    void constructor_with_always_strategy() {
        LadderRow ladderRowWithAlwaysConnect = new LadderRow(4, AlwaysConnectStrategy.getInstance());
        assertThat(ladderRowWithAlwaysConnect.print())
                .isEqualTo("|-----|     |-----|     |");
    }

    @Test
    @DisplayName("isRightConnected 메소드는, 오른쪽으로 연결되어 있는지 여부를 반환한다.")
    void isRightConnected() {
        assertThat(ladderRow.isRightConnected(1)).isEqualTo(false);
        assertThat(ladderRow.isRightConnected(2)).isEqualTo(true);
    }

    @Test
    @DisplayName("isLeftConnected 메소드는, 오른쪽으로 연결되어 있는지 여부를 반환한다.")
    void isLeftConnected() {
        assertThat(ladderRow.isLeftConnected(1)).isEqualTo(true);
        assertThat(ladderRow.isLeftConnected(2)).isEqualTo(false);
    }

    @Test
    @DisplayName("사다리간에 연속된 줄이 생기면, 결과가 중복될 수 있으므로 생성시에 제거해준다.")
    void construct_with_removing_continuous_point() {
        LadderRow ladderRowWithAlwaysConnect = new LadderRow(
                new Boolean[] {
                        true, true, true, true
                }
        );
        assertThat(ladderRowWithAlwaysConnect.print())
                .isEqualTo("|-----|     |-----|     |");
    }
}
