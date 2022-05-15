package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class LineTest {

    @Test
    @DisplayName("참가자의 수만큼 라인을 생성합니다.")
    void participantCreate() {
        Line line = new Line(4);
        assertThat(line.barsCount()).isEqualTo(4);
    }

    @Test
    @DisplayName("사다리의 바의 갯수는 참가지의 갯수와 같습니다.")
    void create() {
        Line line = new Line(
                List.of(
                        true,
                        false,
                        true,
                        false
                )
        );
        assertThat(line.barsCount()).isEqualTo(4);
    }

    @Test
    @DisplayName("사다리의 바는 연속으로 생성이 될 수 없습니다.")
    void notContinuityTrueBar() {
        assertThrows(IllegalArgumentException.class, () -> {
            Line.from(
                    List.of(
                            true,
                            true,
                            false
                    )
            );
        });
    }

    @Test
    @DisplayName("마지막 참가자의 바는 생성이 되지 않습니다.")
    void lastCrateBar() {
        assertThrows(IllegalArgumentException.class, () -> {
            Line.from(
                    List.of(
                            true,
                            true
                    )
            );
        });
    }

    @ParameterizedTest(name = "라인는 반드시 생성이 되야 합니다.")
    @EmptySource
    void inputNull(List<Boolean> lines) {
        assertThrows(IllegalArgumentException.class, () -> {
            Line line =  Line.from(lines);
        });
    }

}