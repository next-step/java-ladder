package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class LadderLineTest {

    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmpty(final List<Point> points) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new LadderLine(points));
    }

    @DisplayName("너무 적은 포인트 목록을 가지고 있을 경우, 에러 발생 시켜야 한다")
    @Test
    void tooFewPoints() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new LadderLine(Collections.singletonList(Point.valueOf(true))));
    }

    @DisplayName("연속으로 연결된 포인트 목록을 가지고 있을 경우, 에러 발생 시켜야 한다")
    @ParameterizedTest
    @CsvSource(value = {
        "true:true:true",
        "false:true:true",
        "true:true:false",
    }, delimiter = ':')
    void pointsConnectedInRow(final boolean value1, final boolean value2, final boolean value3) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new LadderLine(
            List.of(
                Point.valueOf(value1),
                Point.valueOf(value2),
                Point.valueOf(value3)
            )));
    }

    @DisplayName("연속으로 연결된 포인트 목록을 가지고 있지 않을 경우, 에러 발생 하지 않아야 한다")
    @ParameterizedTest
    @CsvSource(value = {
        "false:false:false",
        "false:false:true",
        "false:true:false",
        "true:false:false",
        "true:false:false",
        "true:false:true",
    }, delimiter = ':')
    void validPoints_notConnectedInRow(final boolean value1, final boolean value2, final boolean value3) {
        assertThatCode(() -> new LadderLine(
            List.of(
                Point.valueOf(value1),
                Point.valueOf(value2),
                Point.valueOf(value3)
            ))).doesNotThrowAnyException();
    }

    @DisplayName("주어진 포인트목록 보다 작거나 큰 인덱스를 이용해 노드여부를 물어볼 경우, 에러 발생 시켜야 한다")
    @ParameterizedTest
    @ValueSource(ints = {-10, -1, 2, 3, 5})
    void isNode_outOfRange(final int index) {
        final LadderLine ladderLine = new LadderLine(List.of(Point.valueOf(false), Point.valueOf(true)));
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> ladderLine.isNode(index));
    }

    @DisplayName("주어진 포인트목록 범위 중의 인덱스를 이용해 노드여부를 물어볼경우, 에러 발생 하지 않고, 노드 여부를 반환 할 수 있어야 한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void isNode_validRange(final int index) {
        final LadderLine ladderLine = new LadderLine(List.of(Point.valueOf(false), Point.valueOf(true)));
        assertAll(
            () -> assertThatCode(() ->ladderLine.isNode(index)).doesNotThrowAnyException(),
            () -> assertThat(ladderLine.isNode(0)).isFalse(),
            () -> assertThat(ladderLine.isNode(1)).isTrue()
        );
    }


}