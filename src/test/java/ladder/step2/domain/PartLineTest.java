package ladder.step2.domain;

import ladder.step2fixture.domain.PartLineFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PartLineTest {
    @Test
    @DisplayName("부분 라인 생성")
    void create() {
        assertThat(PartLineFixture.TRUE).isNotNull();
    }
    
    @Test
    @DisplayName("부분 라인 존재 여부 확인")
    void checkExist() {
        assertAll(
                () -> assertThat(PartLineFixture.TRUE.isExist()).isTrue(),
                () -> assertThat(PartLineFixture.FALSE.isExist()).isFalse()
        );
    }
}
