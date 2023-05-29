package ladder.domain;

import ladder.generator.RandomPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderTest {

    public static final int USER_COUNT = 4;

    @DisplayName("Ladder객체 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4})
    void Ladder객체_생성(int height) {
        Ladder ladder = Ladder.create(USER_COUNT, height, new RandomPointGenerator());
        assertThat(ladder.height()).isEqualTo(height);
    }

    //

    @DisplayName("Ladder객체 생성 테스트_비어있는 경우")
    @Test
    void Ladder객체_생성_비어있는경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.create(null))
                .withMessageMatching("Line is Empty");
    }
}
