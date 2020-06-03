package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PillarTest {

    @DisplayName("기둥의 최소 개수인 1보다 작은 수로 기둥을 만들 수 없음")
    @Test
    void createFailure() {
        assertThatIllegalArgumentException().isThrownBy(() -> Pillar.of(PillarCount.of(PillarCount.MIN_COUNT - 1)));
    }

    @DisplayName("Pillar 생성")
    @Test
    void create() {
        assertThatCode(() -> Pillar.of(PillarCount.of(PillarCount.MIN_COUNT)))
                .doesNotThrowAnyException();
    }
}
