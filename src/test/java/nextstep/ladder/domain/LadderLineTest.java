package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderLineTest {
    List<Bridge> normalBridges;

    @BeforeEach
    void setUp() {
        normalBridges = List.of(new Bridge(false, true), new Bridge(true, false));
    }

    @Test
    @DisplayName("생성자 동작 확인 - 정상")
    void create() {
        assertThat(new LadderLine(normalBridges)).isInstanceOf(LadderLine.class);
    }

    @Test
    @DisplayName("생성자 동작 확인 -  Bridge 정보 불일치")
    void create_invalid_bridge() {
        List<Bridge> bridges = List.of(new Bridge(false, true), new Bridge(false, false));
        assertThatThrownBy(() -> new LadderLine(bridges))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LadderLine.INVALID_PAIR_MESSAGE);
    }

    @Test
    @DisplayName("LadderLine.generate로 생성된 LadderLine 사이즈 확인")
    void generate() {
        LadderLine ladderLine = new LadderLine(normalBridges);
        LadderLine generatedLine = LadderLine.generate(2);
        assertThat(generatedLine.sameSize(ladderLine)).isTrue();
    }

    @Test
    @DisplayName("사다리 라인 생성 시 비어 있는 값이 올 수 없음(empty) - 실패")
    void empty_case() {
        assertThatThrownBy(() -> new LadderLine(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LadderLine.INVALID_LINE_SIZE_MESSAGE);
    }

    @Test
    @DisplayName("사다리 라인 생성 시 첫번째 Bridge는 왼쪽으로 연결되어 있으면 안됨 - 실패")
    void first_bridge_has_left_connected() {
        assertThatThrownBy(() -> new LadderLine(List.of(new Bridge(true, false), new Bridge(false, false))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LadderLine.FIRST_BRIDGE_CANNOT_LEFT_CONNECTED);
    }

    @Test
    @DisplayName("사다리 라인 생성 시 마지막 Bridge는 오른쪽으로 연결되어 있으면 안됨 - 실패")
    void last_bridge_has_right_connected() {
        assertThatThrownBy(() -> new LadderLine(List.of(new Bridge(false, false), new Bridge(false, true))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LadderLine.LAST_BRIDGE_CANNOT_RIGHT_CONNECTED);
    }

    @Test
    @DisplayName("LadderLine의 Bridge가 같은 size인지 확인")
    void checkSameBridgeSize() {
        LadderLine ladderLine1 = new LadderLine(normalBridges);
        LadderLine ladderLine2 = new LadderLine(normalBridges);
        LadderLine ladderLine3 = new LadderLine(List.of(new Bridge(false, true), new Bridge(true, false), new Bridge(false, false)));

        assertThat(ladderLine1.sameSize(ladderLine2)).isTrue();
        assertThat(ladderLine1.sameSize(ladderLine3)).isFalse();
    }

    @Test
    @DisplayName("사다리 이동 결과 확인")
    void get_next_position() {
        LadderLine ladderLine = new LadderLine(normalBridges);
        assertThat(ladderLine.nextPosition(0)).isEqualTo(1);
        assertThat(ladderLine.nextPosition(1)).isEqualTo(0);
    }
}
