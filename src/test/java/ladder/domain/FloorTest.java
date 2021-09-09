package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FloorTest {
    @DisplayName("사다리의 한 Floor은 참가자 수를 입력 받아 생성된다.")
    @Test
    void create() {
        assertThat(new Floor(5)).isNotNull();
    }

    @DisplayName("입력된 참가자 수는 1이상이 되지 못하면 Exception 발생한다.")
    @ParameterizedTest(name = "{arguments} {displayName}")
    @ValueSource(ints = {0})
    void validate(int countOfParticipants) {
        assertThatThrownBy(() -> new Floor(countOfParticipants)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성된 Floor에서 라인끼리 인접하지 않아야 한다.")
    @Test
    void generateLines() {
        assertThat(checkLines(new Floor(10).getLines())).isTrue();
    }

    @Test
    void generateLines2() {
        assertThat(checkLines(new Floor(10, GenerateLineMethod.create()).getLines())).isTrue();
    }

    private boolean checkLines(List<Boolean> lines) {
        for (int i = 1; i < lines.size(); i++) {
            if (lines.get(i - 1) == true && lines.get(i - 1) == lines.get(i)) {
                return false;
            }
        }

        return true;
    }
}

