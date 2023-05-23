package ladder.domain;

import ladder.generator.RandomPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {
    @DisplayName("Line 객체 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    void Line객체_생성(int userCount) {
        Line line = Line.create(userCount, new RandomPointGenerator());

        assertThat(line.size()).isEqualTo(userCount);
    }

    @DisplayName("Line 객체 생성 테스트_비어있는 경우")
    @Test
    void Line객체_생성_비어있는_경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Line.create(null))
                .withMessageMatching("Line is Empty");
    }

    @DisplayName("참여자 수가 부족해 Line 생성이 불가한 경우")
    @Test
    void Line객체_생성_참여자수_부족() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Line.create(0, new RandomPointGenerator()))
                .withMessageMatching("참여자 수는 1명 이상이어야 합니다.");
    }
}
