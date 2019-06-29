package com.jaeyeonling.ladder.domain.line;

import com.jaeyeonling.ladder.domain.user.CountOfUsers;
import com.jaeyeonling.ladder.domain.user.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StrategyBaseLineGeneratorTest {

    @DisplayName("첫 포인트는 무조건 False를 리턴한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연,matt,kjy,ggg,다섯글자다",
            "김,kjy,글자다"
    })
    void should_return_false_when_if_firstPoint() {
        final LineGenerator lineGenerator = StrategyBaseLineGenerator.of(() -> true);

        final Users users = Users.of("1ddd,g23,g3223");
        final CountOfUsers countOfUsers = users.getCountOfUsers();

        final Line line = lineGenerator.generate(countOfUsers);

        final List<Boolean> points = line.getPoints();
        final boolean first = points.get(0);

        assertThat(first).isFalse();
    }

    @DisplayName("앞 포인트가 True면 다음 포인트는 무조건 False를 리턴한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연,matt,kjy,ggg,다섯글자다",
            "김,kjy,글자다"
    })
    void should_return_false_when_if_before_point_true_by_trueStrategy(final String rawUsers) {
        should_return_false_when_if_before_point_true(rawUsers, () -> true);
        should_return_false_when_if_before_point_true(rawUsers, () -> false);
    }

    private void should_return_false_when_if_before_point_true(final String rawUsers,
                                                               final PointGenerateStrategy pointGenerateStrategy) {
        final LineGenerator lineGenerator = StrategyBaseLineGenerator.of(pointGenerateStrategy);

        final Users users = Users.of(rawUsers);
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
