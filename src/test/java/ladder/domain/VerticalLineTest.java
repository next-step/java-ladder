package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class VerticalLineTest {
    @Test
    @DisplayName("객체 생성")
    void create() {
        // given
        VerticalLine verticalLine = new VerticalLine(5);

        // when
        assertThat(verticalLine).isNotNull();
    }

    @Test
    @DisplayName("다른 라인과 연결")
    void connect() {
        // given
        VerticalLine verticalLine = new VerticalLine(5);
        VerticalLine verticalLine2 = new VerticalLine(5);

        // when
        verticalLine.connect(verticalLine2, 0);

        // then
        assertThat(verticalLine.connectedCount()).isEqualTo(1);
        assertThat(verticalLine2.connectedCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("높이")
    void height() {
        // given
        VerticalLine verticalLine = new VerticalLine(5);

        // when
        int actual = verticalLine.height();

        // then
        assertThat(actual).isEqualTo(5);
    }

    @Test
    @DisplayName("오른쪽 라인 연결 여부 반환")
    void checkRightConnection() {
        // given
        VerticalLine verticalLine = new VerticalLine(5);
        VerticalLine verticalLine2 = new VerticalLine(5);

        // when
        verticalLine.connect(verticalLine2, 0);
        verticalLine.connect(verticalLine2, 3);
        List<Boolean> actual = IntStream.range(0, 5)
                .mapToObj(verticalLine::checkRightConnection)
                .collect(Collectors.toList());

        // then
        assertThat(actual).containsExactly(true, false, false, true, false);
    }


}