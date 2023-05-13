package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class LineFactoryTest {
    @Test
    @DisplayName("Line 객체 생성")
    void create() {
        // given
        LineFactory lineFactory = new LineFactory(evenConnectedConnectionsFactory());

        // when
        Line line = lineFactory.create(4);

        // then
        assertThat(line).isEqualTo(new Line(true, false, true, false));
    }

    @Test
    @DisplayName("0보다 작은 라인의 연결 갯수로 Line 객체 생성 시, IllegalArgumentException 예외 발생")
    void invalid_number_of_connections() {
        // given
        LineFactory lineFactory = new LineFactory(evenConnectedConnectionsFactory());
        int invalidNumberOfConnections = -1;

        // when, then
        assertThatThrownBy(() -> lineFactory.create(invalidNumberOfConnections))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("라인 연결수는 0 미만이 될 수 없습니다: " + invalidNumberOfConnections);
    }

    private ConnectionsFactory evenConnectedConnectionsFactory() {
        return numberOfConnections -> new Connections(evenElementTrueList(numberOfConnections));
    }

    private List<Boolean> evenElementTrueList(int size) {
        return IntStream.range(0, size)
                .mapToObj(index -> index % 2 == 0)
                .collect(Collectors.toUnmodifiableList());
    }
}