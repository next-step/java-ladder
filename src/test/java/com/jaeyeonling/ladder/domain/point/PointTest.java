package com.jaeyeonling.ladder.domain.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @DisplayName("포인트 생성에 성공한다.")
    @Test
    void should_create() {
        // when
        final Point point = Point.of(1, 1);

        // then
        assertThat(point).isNotNull();
    }
}
