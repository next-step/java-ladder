package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class LadderFactoryTest {
    @Test
    @DisplayName("0 이하의 높이로 사다리 생성 시, IllegalArgumentException 예외 발생")
    void invalid_height_then_throw_IllegalArgumentException() {
        // given
        LadderFactory ladderFactory = new LadderFactory(evenConnectedLineFactory());
        int invalidHeight = 0;

        // when, then
        assertThatThrownBy(() -> ladderFactory.create(5, invalidHeight))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 0 이하일 수 없습니다: " + invalidHeight);
    }

    @Test
    @DisplayName("ladder 객체 생성")
    void create_ladder_object() {
        // given
        LadderFactory ladderFactory = new LadderFactory(evenConnectedLineFactory());
        int height = 3;
        int numberOfLine = 4;

        // when
        Ladder ladder = ladderFactory.create(numberOfLine, height);

        // then
        assertThat(ladder).isEqualTo(new Ladder(
                new Line(true, false, true),
                new Line(true, false, true),
                new Line(true, false, true))
        );
    }

    private LineFactory evenConnectedLineFactory() {
        return new LineFactory(evenConnectedConnectionsFactory());
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