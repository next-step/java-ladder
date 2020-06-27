package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @DisplayName("사다리 생성 시 유저 수 만큼의 라인이 생성된다")
    @ParameterizedTest
    @CsvSource(value = {"4,3", "3,4", "5,5"})
    void createLadderTest(int height, int countOfPerson){
        // when
        Ladder ladder = new Ladder(height, countOfPerson);

        // then
        assertThat(ladder.getLines()).hasSize(countOfPerson);
    }

    @DisplayName("유저 수가 2보다 작거나 높이가 1보다 작은 경우 예외 발생")
    @ParameterizedTest
    @CsvSource(value = {"0,3", "-1,4", "5,1"})
    void validationCheckTest(int height, int countOfPerson){
        // then
        assertThatThrownBy(() -> new Ladder(height, countOfPerson))
                .isInstanceOf(IllegalArgumentException.class);
    }
}