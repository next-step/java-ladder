package ladder.domain;

import ladder.domain.ladder.AutoLineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLineGeneratorTest {
    @DisplayName("정적 팩토리 메소드 create를 통해 AutoLineGenerator 인스턴스 생성한다.")
    @Test
    void create() {
        assertThat(AutoLineGenerator.create()).isNotNull();
    }
}
