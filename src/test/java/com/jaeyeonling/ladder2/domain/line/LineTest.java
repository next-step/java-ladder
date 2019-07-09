package com.jaeyeonling.ladder2.domain.line;

import com.jaeyeonling.ladder2.domain.Index;
import com.jaeyeonling.ladder2.domain.user.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("첫 방향이 오른쪽이면 위치가 " + Index.INCREMENT_VALUE + " 증가한다.")
    @Test
    void firstRight() {
        // given
        final DirectionGenerateStrategy strategy = () -> true;
        final Users users = Users.ofSeparator("a");

        final Line line = Line.generate(strategy, users);
        final Index defaultIndex = Index.valueOf(0);

        // when
        final Index movedIndex = line.move(defaultIndex);

        // then
        assertThat(movedIndex).isEqualTo(defaultIndex.increment());
    }

    @DisplayName("첫 방향이 직진이면 이동 하지 않는다.")
    @Test
    void firstStraight() {
        // given
        final DirectionGenerateStrategy strategy = () -> false;
        final Users users = Users.ofSeparator("a");

        final Line line = Line.generate(strategy, users);
        final Index defaultIndex = Index.valueOf(0);

        // when
        final Index movedIndex = line.move(defaultIndex);

        // then
        assertThat(movedIndex).isEqualTo(defaultIndex);
    }

    @DisplayName("중간 방향이 왼쪽이면 위치가 " + Index.INCREMENT_VALUE + " 감소한다.")
    @Test
    void middleLeft() {
        // given
        final DirectionGenerateStrategy strategy = () -> true;
        final Users users = Users.ofSeparator("a,b,c,d");

        final Line line = Line.generate(strategy, users);
        final Index defaultIndex = Index.valueOf(1);

        // when
        final Index movedIndex = line.move(defaultIndex);

        // then
        assertThat(movedIndex).isEqualTo(defaultIndex.decrement());
    }

    @DisplayName("중간 방향이 직진이면 이동 하지 않는다.")
    @Test
    void middleStraight() {
        // given
        final DirectionGenerateStrategy strategy = () -> false;
        final Users users = Users.ofSeparator("a,b,c,d");

        final Line line = Line.generate(strategy, users);
        final Index defaultIndex = Index.valueOf(1);

        // when
        final Index movedIndex = line.move(defaultIndex);

        // then
        assertThat(movedIndex).isEqualTo(defaultIndex);
    }

    @DisplayName("중간 방향이 오른쪽이면 위치가 " + Index.INCREMENT_VALUE + " 증가한다.")
    @Test
    void middleRight() {
        // given
        final DirectionGenerateStrategy strategy = () -> true;
        final Users users = Users.ofSeparator("a,b,c,d");

        final Line line = Line.generate(strategy, users);
        final Index defaultIndex = Index.valueOf(2);

        // when
        final Index movedIndex = line.move(defaultIndex);

        // then
        assertThat(movedIndex).isEqualTo(defaultIndex.increment());
    }

    @DisplayName("마지막 방향이 왼쪽이면 위치가 " + Index.INCREMENT_VALUE + " 감소한다.")
    @Test
    void lastLeft() {
        // given
        final DirectionGenerateStrategy strategy = () -> true;
        final Users users = Users.ofSeparator("a,b,c,d");

        final Line line = Line.generate(strategy, users);
        final Index defaultIndex = Index.valueOf(3);

        // when
        final Index movedIndex = line.move(defaultIndex);

        // then
        assertThat(movedIndex).isEqualTo(defaultIndex.decrement());
    }

    @DisplayName("중간 방향이 직진이면 이동 하지 않는다.")
    @Test
    void lastStraight() {
        // given
        final DirectionGenerateStrategy strategy = () -> false;
        final Users users = Users.ofSeparator("a,b,c,d");

        final Line line = Line.generate(strategy, users);
        final Index defaultIndex = Index.valueOf(3);

        // when
        final Index movedIndex = line.move(defaultIndex);

        // then
        assertThat(movedIndex).isEqualTo(defaultIndex);
    }
}
