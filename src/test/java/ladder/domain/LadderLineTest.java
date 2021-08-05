package ladder.domain;

import ladder.domain.direction.FakeDirectionGenerator;
import ladder.factory.FakeLadderFactoryBean;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {
    @BeforeAll
    public static void setUp() {
        // RIGHT-LEFT-EMPTY 순으로 반복해서 생성해주는 생성기로 교체
        new FakeLadderFactoryBean(
                new FakeDirectionGenerator()
        ).changeInstance();
    }

    @ValueSource(ints = {
            10, 100, 1000
    })
    @DisplayName("generate 갯수 테스트")
    @ParameterizedTest
    public void generateTest(int size) {
        assertThat(
                LadderLine.generate(size).size()
        ).isEqualTo(size);
    }

    @CsvSource({"0,1", "1,0", "2,2", "3,4", "4,3", "5,5"})
    @DisplayName("move가 정상적으로 움직였는지 테스트")
    @ParameterizedTest
    void moveTest(int index, int correctIndex) {
        LadderLine line = LadderLine.generate(6);
        assertThat(
                line.move(index)
        ).isEqualTo(correctIndex);
    }
}
