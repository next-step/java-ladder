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
        final LadderHeight ladderHeight = new LadderHeight(5);
        final Ladder ladder = new Ladder(participants, ladderHeight, new Lines(List.of(new Line(List.of(true)))));

        assertAll(
                () -> assertThat(ladder.getParticipants()
                                       .size()).isEqualTo(4),
                () -> assertThat(ladder.getHeight()).isEqualTo(new LadderHeight(5)),
                () -> assertThat(ladder.getLines()
                                       .size()).isEqualTo(1)
        );
    }

    @DisplayName("사다리 생성 실패")
    @Test
    void invalid() {
        final Participants participants = new Participants(Stream.of("woody", "jacob", "tate", "test")
                                                                 .map(Participant::new)
                                                                 .collect(Collectors.toList()));
        final LadderHeight ladderHeight = new LadderHeight(5);
        final Ladder ladder = new Ladder(participants, ladderHeight, new Lines(List.of(new Line(List.of(true)))));

        assertAll(
                () -> assertThatThrownBy(() -> new Ladder(null, ladderHeight,
                        new Lines(List.of(new Line(List.of(true)))))),
                () -> assertThatThrownBy(() -> new Ladder(participants, null,
                        new Lines(List.of(new Line(List.of(true)))))),
                () -> assertThatThrownBy(() -> new Ladder(participants, ladderHeight, null))
        );
    }
}
