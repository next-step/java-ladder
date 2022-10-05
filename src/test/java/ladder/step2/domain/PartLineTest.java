package ladder.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PartLineTest {
    public static final PartLine TRUE = new PartLine(true);
    public static final PartLine FALSE = new PartLine(false);
    
    @Test
    @DisplayName("부분 라인 생성")
    void create() {
        assertThat(PartLineTest.TRUE).isNotNull();
    }
    
    @Test
    @DisplayName("부분 라인 존재 여부 확인")
    void checkExist() {
        assertAll(
                () -> assertThat(PartLineTest.TRUE.isExist()).isTrue(),
                () -> assertThat(PartLineTest.FALSE.isExist()).isFalse()
        );
    }
}
