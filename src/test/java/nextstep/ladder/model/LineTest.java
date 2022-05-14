package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class LineTest {

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
            Line line = new Line(
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
            Line line = new Line(
                    List.of(
                            true,
                            true
                    )
            );
        });
    }

    @Test
    @DisplayName("참가자는 최소 2명이상이어야 합니다.")
    void createTwoBars() {
        assertThrows(IllegalArgumentException.class, () -> {
            Line line = new Line(
                    List.of(
                            false
                    )
            );
        });
    }
}