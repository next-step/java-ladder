package ladder.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.exception.LineInvalidException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {
    @Test
    @DisplayName("유효한 links 리스트로 Line 생성 성공")
    void createLineWithValidLinks() {
        List<Boolean> links = Arrays.asList(false, true, false, true, false);

        Line line = new Line(links);

        assertThat(line).isNotNull();
        assertThat(line.getLinks()).isEqualTo(links);
    }

    @Test
    @DisplayName("연속된 true 값이 있는 links 리스트로 Line 생성 시 예외 발생")
    void createLineWithInvalidLinksThrowsException() {
        List<Boolean> invalidLinks = Arrays.asList(false, true, true, false);

        assertThatThrownBy(() -> new Line(invalidLinks))
            .isInstanceOf(LineInvalidException.class);
    }

    @Test
    @DisplayName("빈 links 리스트로 Line 생성 시 예외 발생")
    void createLineWithEmptyLinksThrowsException() {
        List<Boolean> emptyLinks = List.of();

        assertThatThrownBy(() -> new Line(emptyLinks))
            .isInstanceOf(LineInvalidException.class);
    }

    @Test
    @DisplayName("null links 리스트로 Line 생성 시 예외 발생")
    void createLineWithNullLinksThrowsException() {
        List<Boolean> nullLinks = null;

        assertThatThrownBy(() -> new Line(nullLinks))
            .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("links가 [true, false, false]일 때: 0번 인덱스는 오른쪽 이동, 1번은 왼쪽 이동, 나머지는 이동 없음")
    void getMove_왼쪽으로_이동() {
        Line line = new Line(List.of(true, false, false));
        assertThat(line.getMove(0)).isEqualTo(1);
        assertThat(line.getMove(1)).isEqualTo(-1);
        assertThat(line.getMove(2)).isEqualTo(0);
        assertThat(line.getMove(3)).isEqualTo(0);
    }

    @Test
    @DisplayName("links가 [false, true, false]일 때: 1번 인덱스는 오른쪽 이동, 2번은 왼쪽 이동")
    void getMove_오른쪽으로_이동() {
        Line line = new Line(List.of(false, true, false));
        assertThat(line.getMove(0)).isEqualTo(0);
        assertThat(line.getMove(1)).isEqualTo(1);
        assertThat(line.getMove(2)).isEqualTo(-1);
        assertThat(line.getMove(3)).isEqualTo(0);
    }

    @Test
    @DisplayName("links가 모두 false일 때: 모든 인덱스에서 이동 없음")
    void getMove_이동없음() {
        Line line = new Line(List.of(false, false, false));
        assertThat(line.getMove(0)).isEqualTo(0);
        assertThat(line.getMove(1)).isEqualTo(0);
        assertThat(line.getMove(2)).isEqualTo(0);
        assertThat(line.getMove(3)).isEqualTo(0);
    }
}
