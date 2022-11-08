package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderTest {

    @DisplayName("사다리 생성")
    @Test
    void create() {
        final Participants participants = new Participants(Stream.of("woody", "jacob", "tate", "test")
                                                                 .map(Participant::new)
                                                                 .collect(Collectors.toList()));
        final Ladder ladder = new Ladder(participants, new Lines(List.of(new Line(List.of(true)))));

        assertAll(
                () -> assertThat(ladder.getParticipants()
                                       .size()).isEqualTo(4),
                () -> assertThat(ladder.getLines()
                                       .height()).isEqualTo(1)
        );
    }

    @DisplayName("사다리 생성 실패")
    @Test
    void invalid() {
        final Participants participants = new Participants(Stream.of("woody", "jacob", "tate", "test")
                                                                 .map(Participant::new)
                                                                 .collect(Collectors.toList()));

        assertAll(
                () -> assertThatThrownBy(() -> new Ladder(null,
                        new Lines(List.of(new Line(List.of(true)))))),
                () -> assertThatThrownBy(() -> new Ladder(participants, null))
        );
    }
}
