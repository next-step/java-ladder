package ladder.domain.prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PrizeTest {

    @DisplayName("사타리 타기 결과값 이름이 5글자 보다 크면 예외 발생")
    @Test
    void createFailure() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Prize.of("winner"));
    }

    @DisplayName("사타리 타기 결과값 생성")
    @Test
    void create() {
        assertThatCode(() -> Prize.of("3000"))
                .doesNotThrowAnyException();
    }

    @DisplayName("논리적 동치성 비교")
    @Test
    void equals() {
        assertThat(Prize.of("3000"))
                .isEqualTo(Prize.of("3000"));
    }
}
