package ladder;

import ladder.domain.LadderBuildingException;
import ladder.domain.LadderFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderFactoryTest {

    @DisplayName("LadderFactory 객체 정상 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {5, 10, 15})
    public void makeLadderFactory_정상(int ladderHeight) {
        assertThatCode(() -> {
            new LadderFactory(ladderHeight);
        }).doesNotThrowAnyException();
    }

    @DisplayName("LadderFactory 객체 정상 생성 실패 테스트(사다리 길이가 1 미만일 경우)")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    public void makeLadderFactory_예외(int ladderHeight) {
        assertThatThrownBy(() -> {
            new LadderFactory(ladderHeight);
        }).isInstanceOf(LadderBuildingException.class)
                .hasMessageContaining(LadderBuildingException.INVALID_LADDER_HEIGHT);
    }
}
