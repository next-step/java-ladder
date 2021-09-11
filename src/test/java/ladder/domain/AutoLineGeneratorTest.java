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

    @DisplayName("라인끼리 인접하지 않고 한 층의 임의의 라인들을 자동으로 생성한다.")
    @Test
    void generate() {
        assertThat(hasAdjecentLines(AutoLineGenerator.create().generate(10))).isFalse();
    }

    boolean hasAdjecentLines(List<Boolean> lines) {
        for (int i = 1; i < lines.size(); i++) {
            if (lines.get(i - 1) == true && lines.get(i - 1) == lines.get(i)) {
                return true;
            }
        }

        return false;
    }
}
