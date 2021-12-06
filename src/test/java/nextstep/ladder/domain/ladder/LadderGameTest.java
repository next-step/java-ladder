package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.ladder.size.LadderWidth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameTest {

    @DisplayName("참가자의 수는 2이상 이어야 한다.")
    @ParameterizedTest(name = "[{index}] participants: {0}")
    @MethodSource("createTooFewParticipantsArguments")
    void create_tooFewParticipants_throwsException(List<Participant> participants) {
        LadderLine ladderLine = LadderLine.of(new LadderWidth(2), () -> true);
        Ladder ladder = new Ladder(singletonList(ladderLine));

        assertThatThrownBy(() -> new LadderGame(participants, ladder))
                .isInstanceOf(TooFewParticipantsException.class);
    }

    public static Stream<Arguments> createTooFewParticipantsArguments() {
        return Stream.of(
                Arguments.of((Object) null),
                Arguments.of(emptyList()),
                Arguments.of(singletonList(new Participant("홍길동")))
        );
    }

}
