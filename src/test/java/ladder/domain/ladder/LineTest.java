package ladder.domain.ladder;

import ladder.domain.participant.Participants;
import ladder.domain.strategy.LineGenerateStrategy;
import ladder.exception.PointListNullPointerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LineTest {

    @DisplayName("Line 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        Participants participants = Participants.of("a,b,c,".split(","));
        LineGenerateStrategy strategy = () -> true;

        // when
        Line line = Line.of(participants, strategy);

        // then
        assertThat(line).isNotNull();
    }

    @DisplayName("Line 인스턴스에 null 주입시 예외처리 여부 테스트")
    @Test
    void 검증_null() {
        // given
        List<Point> pointList = null;

        // when and then
        assertThatThrownBy(() -> Line.of(pointList))
                .isInstanceOf(PointListNullPointerException.class)
                .hasMessage("List<Point>가 null 입니다.");

    }

    @DisplayName("Line 인스턴스가 원하는 인스턴스를 생성하는지 테스트")
    @Test
    void 비교() {
        // given
        Participants participants = Participants.of("a,b,c,".split(","));
        LineGenerateStrategy strategy = () -> true;

        Point first = Point.first(true);
        Point second = first.next(strategy);
        Point third = second.last();
        List<Point> pointList = Arrays.asList(first, second, third);

        // when
        Line actual = Line.of(participants, strategy);
        Line expected = Line.of(pointList);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("Line 인스턴스가 Stream<List<Point>를 반환하는지 테스트")
    @Test
    void 반환_stream() {
        // given
        Participants participants = Participants.of("a,b,c,".split(","));
        LineGenerateStrategy strategy = () -> true;

        // when
        Line line = Line.of(participants, strategy);

        // then
        assertAll(
                () -> assertThat(line.stream()).isInstanceOf(Stream.class),
                () -> assertThat(line.stream()).isNotNull()
        );

    }
}