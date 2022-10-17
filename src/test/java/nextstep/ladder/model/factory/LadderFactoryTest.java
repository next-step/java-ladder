package nextstep.ladder.model.factory;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LadderFactoryTest {
    @ParameterizedTest(name = "사다리의 길이와 사람 수가 주어질 때, 사다리를 생성한다. 길이: {0}, 사람 수: {1}")
    @CsvSource({
        "3,3",
        "1,3"
    })
    void create(int ladderLength, int countOfPerson) {
        LadderFactory.create(ladderLength, countOfPerson, () -> true);
    }

    @ParameterizedTest(name = "부적절한 사다리의 길이가 주어졌을 때, 예외가 던져진다. 길이: {0}")
    @ValueSource(ints = {-1, 0})
    void createWithInvalidLength(int ladderLength) {
        assertThatThrownBy(() -> LadderFactory.create(ladderLength, 3, () -> true))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("사다리의 높이는 양수여야 합니다");
    }
}
