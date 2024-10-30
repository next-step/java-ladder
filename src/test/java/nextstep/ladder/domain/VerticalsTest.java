package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.BooleanStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class VerticalsTest {

    @DisplayName("2명이면 선은 1개, 선은 그리는 것으로 하기")
    @Test
    void 전략패턴_검증() {
        Verticals verticals = new Verticals(2, new BooleanStrategy() {
            @Override
            public boolean decide() {
                return true;
            }
        });

        assertAll(
                () -> assertThat(verticals.getVertical()).hasSize(1),
                () -> assertThat(verticals.getVertical().get(0)).isTrue()
        );
    }
}
