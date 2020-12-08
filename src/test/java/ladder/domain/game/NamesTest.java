package ladder.domain.game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created By mand2 on 2020-12-03.
 */
public class NamesTest {

    @Test
    void 여러_이름을_한번에_받는다() {
        String inputNames = "가,포비,twice";

        Names names = Names.from(inputNames);

        assertThat(names).isEqualTo(Names.from(inputNames));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 참가자_명단은_비어있으면_안된다(String inputNames) {
        assertThatThrownBy(() -> Names.from(inputNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Names.MESSAGE_PARTICIPANTS_LIST_NON_NULL);
    }

    private static Stream<Arguments> providedNameOfParticipantIntoIndex() {
        return Stream.of(
                Arguments.of("pobi,honux,crong,jk", "pobi", 0),
                Arguments.of("pobi,honux,crong,jk", "honux", 1),
                Arguments.of("pobi,honux,crong,jk", "crong", 2),
                Arguments.of("pobi,honux,crong,jk", "jk", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("providedNameOfParticipantIntoIndex")
    void 참가자_이름을_입력하면_참가자의_번호를_반환한다(String inputNames, String participantName, int expectedIndex) {
        Names names = Names.from(inputNames);
        assertThat(
                names.getParticipantIndex(Name.from(participantName))
        ).isEqualTo(expectedIndex);
    }

    @ParameterizedTest
    @MethodSource("providedNameOfParticipantIntoIndex")
    void 참가자_번호를_입력하면_참가자의_이름을_반환한다(String inputNames, String participantName, int expectedIndex) {
        Names names = Names.from(inputNames);
        assertThat(names.getParticipantName(expectedIndex))
                .isEqualTo(Name.from(participantName));
    }
}
