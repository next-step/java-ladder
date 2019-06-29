package com.jaeyeonling.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StrategyBaseLineGeneratorTest {

    @DisplayName("첫 포인트는 무조건 False를 리턴한다.")
    @Test
    void Generate_FirstPointFalse_Always() {
        final LineGenerator lineGenerator = StrategyBaseLineGenerator.of(() -> true);

        final Users users = Users.of("1ddd,g23,g3223");
        final CountOfUsers countOfUsers = users.getCountOfUsers();

        final Line line = lineGenerator.generate(countOfUsers);

        final List<Boolean> points = line.getPoints();
        final boolean first = points.get(0);

        assertThat(first).isFalse();
    }
}
