package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LineTest {

    @DisplayName("사다리 라인 생성")
    @Test
    void create() {
        Line line = new Line(List.of(true, false, false));
        assertAll(
                () -> assertThat(line).isNotNull(),
                () -> assertThat(line.size()).isEqualTo(3)
        );
    }

    @DisplayName("사다리 라인 실패 - 빈 연결")
    @Test
    void invalidConnections() {
        assertThatThrownBy(() -> new Line(Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리 라인은 최소 1개 이상의 연결 정보를 가져야합니다.");
    }

    @DisplayName("사다리 라인 실패 - 연속된 연결 정보")
    @Test
    void continuousConnections() {
        assertThatThrownBy(() -> new Line(List.of(true, true)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("2개 이상의 연결된 다리는 가질 수 없습니다.");
    }
}
