package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.exceptions.PointsNeedMoreThanOnePersonException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderLadderLineFactoryTests {
    private PointAddStrategy simplePointAddStrategy;

    @BeforeEach
    public void setup() {
        simplePointAddStrategy = new SimplePointAddStrategy();
    }

    @DisplayName("참가자가 한명인 라인을 만들 경우 포인트는 무조건 false")
    @Test
    void createTest() {
        int countOfPerson = 1;
        LadderLine ladderLine = LadderLineFactory.create(countOfPerson, simplePointAddStrategy);
        assertThat(ladderLine.size()).isEqualTo(1);
        assertThat(ladderLine.getPointsIndex(0)).isFalse();
    }

    @DisplayName("이전 값이 false인 객체에 add 시 true값이 추가된 컬렉션으로 변화")
    @Test
    void addToFalseTest() {
        int countOfPerson = 5;
        LadderLine ladderLine = LadderLineFactory.create(countOfPerson, simplePointAddStrategy);

        assertThat(ladderLine.size()).isEqualTo(5);
        assertThat(ladderLine.getPointsIndex(0)).isFalse();
        assertThat(ladderLine.getPointsIndex(1)).isTrue();
        assertThat(ladderLine.getPointsIndex(2)).isFalse();
        assertThat(ladderLine.getPointsIndex(3)).isTrue();
        assertThat(ladderLine.getPointsIndex(4)).isFalse();
    }

    @DisplayName("0이하의 인원수로 객체를 생성 할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void createValidationTest(int invalidCountOfPerson) {
        assertThatThrownBy(() -> LadderLineFactory.create(invalidCountOfPerson, simplePointAddStrategy))
                .isInstanceOf(PointsNeedMoreThanOnePersonException.class);
    }
}
