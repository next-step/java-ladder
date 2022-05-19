package nextstep.ladder.model;

import nextstep.ladder.exception.MinimumException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderTest {

    @Test
    @DisplayName("최소 인원 예외 처리")
    void minimum() {
        Person person = Person.is("check");
        Line line = Line.create(1);
        assertAll(() -> assertThatThrownBy(() -> Ladder.start(List.of(person), List.of(line))).isInstanceOf(MinimumException.class),
                () -> assertThatThrownBy(() -> Ladder.start(List.of(person, person, person), List.of(line))).isInstanceOf(MinimumException.class),
                () -> assertThatThrownBy(() -> Ladder.start(List.of(person, person, person), null)).isInstanceOf(MinimumException.class),
                () -> assertThatThrownBy(() -> Ladder.start(List.of(person), List.of(line, line, line))).isInstanceOf(MinimumException.class),
                () -> assertThatThrownBy(() -> Ladder.start(null, List.of(line, line, line))).isInstanceOf(MinimumException.class));
    }
}
