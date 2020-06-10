package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class BaseUserLineTest {

    @DisplayName("유저이름이 5자를 넘기면 익셉션을 던진다")
    @Test
    void name() {
        assertThatThrownBy(() -> new BaseUserLine("abcdef", new ConnectPoints(new HashSet<>(new HashSet<>()))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("유저이름은 5자를 넘길 수 없습니다. 현재글자수: %d", 6));
    }

    @DisplayName("연결된 Point위치의 연결여부를 물어보면 true/false 를 반환한다")
    @Test
    void connect() {
        //given
        Set<Point> points = new HashSet<>();
        points.add(new Point(1));
        points.add(new Point(2));
        ConnectPoints connectPoints = new ConnectPoints(points);
        BaseUserLine userLine = new BaseUserLine("abc", connectPoints);

        //when
        //then
        assertAll(
                () -> assertThat(userLine.isConnected(new Point(1))).isEqualTo(true),
                () -> assertThat(userLine.isConnected(new Point(2))).isEqualTo(true),
                () -> assertThat(userLine.isConnected(new Point(3))).isEqualTo(false)
        );
    }
}