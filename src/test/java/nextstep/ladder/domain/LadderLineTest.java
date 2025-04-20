package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderLineTest {
    @DisplayName("사다리 라인 정상 연결 테스트")
    @Test
    public void connectLine() throws Exception {
        assertThat(new LadderLine(List.of(true,false,true)))
                .isNotNull();
    }

    @DisplayName("사다리 라인 null or empty")
    @Test
    public void invalidConnectLineNullOrEmpty() throws Exception {
        assertThatThrownBy(() -> new LadderLine(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("lines cannot be null or empty");

        assertThatThrownBy(() -> new LadderLine(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("lines cannot be null or empty");
    }

    @DisplayName("사다리 라인 연속해서 연결되어 생성 실패")
    @Test
    public void invalidConnectLine() throws Exception {
        assertThatThrownBy(() -> new LadderLine(List.of(true,true,false)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("Ladder lines cannot be connected continuously.");

        assertThatThrownBy(() -> new LadderLine(List.of(false,true,true)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("Ladder lines cannot be connected continuously.");
    }
}