package ladder.domain;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.exception.LineInvalidException;

class LineTest {
    @Test
    @DisplayName("유효한 links 리스트로 Line 생성 성공")
    void createLineWithValidLinks() {
        List<Boolean> links = Arrays.asList(false, true, false, true, false);

        Line line = new Line(links);

        Assertions.assertThat(line).isNotNull();
        Assertions.assertThat(line.getLinks()).isEqualTo(links);
    }

    @Test
    @DisplayName("연속된 true 값이 있는 links 리스트로 Line 생성 시 예외 발생")
    void createLineWithInvalidLinksThrowsException() {
        List<Boolean> invalidLinks = Arrays.asList(false, true, true, false);

        Assertions.assertThatThrownBy(() -> new Line(invalidLinks))
            .isInstanceOf(LineInvalidException.class)
            .hasMessage(null); // 예외 메시지가 있다면 추가 가능
    }

    @Test
    @DisplayName("빈 links 리스트로 Line 생성 시 예외 발생")
    void createLineWithEmptyLinksThrowsException() {
        List<Boolean> emptyLinks = List.of();

        Assertions.assertThatThrownBy(() -> new Line(emptyLinks))
            .isInstanceOf(LineInvalidException.class)
            .hasMessage(null);
    }

    @Test
    @DisplayName("null links 리스트로 Line 생성 시 예외 발생")
    void createLineWithNullLinksThrowsException() {
        List<Boolean> nullLinks = null;

        Assertions.assertThatThrownBy(() -> new Line(nullLinks))
            .isInstanceOf(NullPointerException.class); // NullPointerException 확인
    }
}
