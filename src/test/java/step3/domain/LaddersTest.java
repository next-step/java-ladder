package step3.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LaddersTest {
    @Test
    void 사다리가_사람수에_맞게_생성되는지() {
        Ladders ladder = new Ladders(5, 4, new RandomLineConditional());
        assertThat(ladder.getLevels().size()).isEqualTo(5);
        assertThat(ladder.getLevels().get(0).getLines().size()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,0", "2,2"})
    void 한명_인덱스로_계산_테스트(int startIndex, int expectedArrivalIndex) {
        Ladders ladder = new Ladders(3, 3, index -> {
            if (index % 2 == 0) {
                return true;
            }
            return false;
        });
        assertThat(ladder.getOneResultIndex(startIndex).get(startIndex)).isEqualTo(expectedArrivalIndex);
    }

    @Test
    void 모든사람_계산_테스트() {
        int userCounts = 3;
        Ladders ladder = new Ladders(3, userCounts, index -> {
            if (index % 2 == 0) {
                return true;
            }
            return false;
        });
        assertThat(ladder.getAllResultIndex(userCounts).get(1)).isEqualTo(0);
    }
}
