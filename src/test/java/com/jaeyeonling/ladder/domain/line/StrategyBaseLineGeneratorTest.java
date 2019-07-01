package com.jaeyeonling.ladder.domain.line;

import com.jaeyeonling.ladder.domain.point.Direction;
import com.jaeyeonling.ladder.domain.user.CountOfUsers;
import com.jaeyeonling.ladder.domain.user.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StrategyBaseLineGeneratorTest {

    @DisplayName("첫 포인트에 LEFT가 올 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연,matt,kjy,ggg,다섯글자다",
            "김,kjy,글자다"
    })
    void should_return_not_left_if_first_direction() {
        final LineGenerator lineGenerator = StrategyBaseLineGenerator.withStrategy(() -> true);

        final Users users = Users.ofSeparator("1ddd,g23,g3223");
        final CountOfUsers countOfUsers = users.getCountOfUsers();

        final Line line = lineGenerator.generate(countOfUsers);
        final List<Direction> directions = line.getDirections();

        final Direction first = directions.get(0);

        assertThat(first).isNotEqualTo(Direction.LEFT);
    }

    @DisplayName("앞이 RIGHT면 다음은 무조건 LEFT를 리턴한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "김재연,matt,kjy,ggg,다섯글자다",
            "김,kjy,글자다"
    })
    void should_return_left_when_if_before_point_right_by(final String rawUsers) {
        should_return_left_when_if_before_point_right_by(rawUsers, () -> true);
        should_return_left_when_if_before_point_right_by(rawUsers, () -> false);
    }

    private void should_return_left_when_if_before_point_right_by(final String rawUsers,
                                                                  final PointGenerateStrategy pointGenerateStrategy) {
        final LineGenerator lineGenerator = StrategyBaseLineGenerator.withStrategy(pointGenerateStrategy);

        final Users users = Users.ofSeparator(rawUsers);
        final CountOfUsers countOfUsers = users.getCountOfUsers();

        final Line line = lineGenerator.generate(countOfUsers);

        final List<Direction> directions = line.getDirections();
        for (int i = 2; i < directions.size(); i++) {
            final Direction before = directions.get(i - 1);
            if (before == Direction.RIGHT) {
                assertThat(directions.get(i)).isEqualTo(Direction.LEFT);
            }
        }
    }
}
