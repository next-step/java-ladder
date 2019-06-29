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

    @DisplayName("앞 포인트가 True면 다음 포인트는 무조건 False를 리턴한다.")
    @Test
    void Generate_IfBeforeTrue_Always() {
        final LineGenerator lineGenerator = StrategyBaseLineGenerator.of(() -> true);

        final Users users = Users.of("1,2,3,4,5,6,7");
        final CountOfUsers countOfUsers = users.getCountOfUsers();

        final Line line = lineGenerator.generate(countOfUsers);

        final List<Boolean> points = line.getPoints();
        for (int i = 2; i < points.size(); i++) {
            final Boolean before = points.get(i - 1);
            if (before) {
                assertThat(points.get(i)).isFalse();
            }
        }
    }
}
