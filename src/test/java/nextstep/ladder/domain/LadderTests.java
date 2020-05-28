package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.InvalidLadderHeightException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTests {
    @DisplayName("사다리의 최대 높이를 입력받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        int ladderHeight = 5;
        int countOfPerson = 3;
        Ladder ladder = Ladder.create(ladderHeight, countOfPerson);
        assertThat(ladder.getHeight()).isEqualTo(ladderHeight);
    }

    @DisplayName("사다리의 최대 높이를 0으로 객체 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void createValidationTest(int invalidLadderHeight) {
        int countOfPerson = 3;
        assertThatThrownBy(() -> Ladder.create(invalidLadderHeight, countOfPerson))
                .isInstanceOf(InvalidLadderHeightException.class);
    }
}
