package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderLineTest {

    @Test
    @DisplayName("Point가 참가자 수만큼 생성된다")
    void create() {
        // given
        int sizeOfPerson = 5;

        // when
        LadderLine ladderLine = LadderLine.of(sizeOfPerson, () -> true);

        // then
        assertThat(ladderLine.getPoints().size()).isEqualTo(sizeOfPerson);
    }

    @DisplayName("라인을 생성됐을때 index를 입력하면 이동하고 결과값을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,0", "2,3", "3,2", "4,4"})
    void move(int index, int expected) {
        // given
        LadderLine line = LadderLine.of(5, () -> true);

        // when
        int result = line.move(index);

        // then
        assertThat(result).isEqualTo(expected);
    }
}