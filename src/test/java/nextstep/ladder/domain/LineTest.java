package nextstep.ladder.domain;

import nextstep.ladder.domain.concrete.Line;
import nextstep.ladder.fixtures.BraceFixtures;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Line은 아무런 Point가 주어지지 않으면 예외를 던진다.")
    void newObject_NullAndEmpty_throwsException(List<Brace> nullAndEmpty) {
        assertThatThrownBy(
                () -> new Line(nullAndEmpty)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Line은 가로 선이 연결되어 있지 않으면 예외를 던진다.")
    void newObject_notConnected_throwsException() {
        List<Brace> braces = List.of(BraceFixtures.right(), BraceFixtures.right());

        assertThatThrownBy(
                () -> new Line(braces)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
