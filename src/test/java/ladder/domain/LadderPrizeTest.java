package ladder.domain;

import ladder.domain.game.LadderPrize;
import ladder.domain.participant.Participant;
import ladder.domain.position.Position;
import ladder.helper.Fixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LadderPrize : 사다리 게임의 결과 값을 저장하고 처리하는 클래스")
public class LadderPrizeTest {
    @DisplayName("LadderPrize 인스턴스는 Prize 이름과 할당된 위치 값을 가진다.")
    @Test
    void create() {
        assertThat(new LadderPrize("prz1", new Position(0, Fixture.ladderSize())));
    }

    @DisplayName("Paricipant 가 갖고있는 Position 값과 LadderPrized가 갖고있는 Position 값을 비교하여 갖은 위치 여부를 판단한다.")
    @ParameterizedTest(name = "{arguments} {displayName}")
    @MethodSource("sourceMatchPrize")
    void matchPrize(LadderPrize ladderPrize, Participant participant, boolean expected) {
        assertThat(ladderPrize.matchPrize(participant)).isEqualTo(expected);
    }

    static Stream<Arguments> sourceMatchPrize() {
        return Stream.of(
                Arguments.of(new LadderPrize("prz1", new Position(5, Fixture.ladderSize())),
                        new Participant("man3", new Position(5, Fixture.ladderSize())),
                        true),
                Arguments.of(new LadderPrize("prz1", new Position(5, Fixture.ladderSize())),
                        new Participant("man3", new Position(6, Fixture.ladderSize())),
                        false)
        );
    }
}
