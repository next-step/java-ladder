package ladder.domain.game;

import ladder.strategy.ConnectionStrategy;
import ladder.strategy.RandomConnectionStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.Connection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created By mand2 on 2020-12-07.
 */
class LadderTest {

    Names participants;
    int height;
    ConnectionStrategy connectionStrategy;

    @BeforeEach
    void setUp() {
        participants = Names.from("pobi,honux,crong,jk");
        connectionStrategy = new RandomConnectionStrategy();
        height = 2;
    }

    @Test
    void 사다리를_생성한다() {
        assertThat(Ladder.of(participants.getParticipantNum(), ()->false, height))
                .isEqualTo(Ladder.of(participants.getParticipantNum(), ()->false, height));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -2})
    void 사다리의_높이가_1이상이_아닐_때_예외(int inputHeight) {
        assertThatThrownBy(() -> Ladder.of(participants.getParticipantNum(), connectionStrategy, inputHeight))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Ladder.MESSAGE_LADDER_HEIGHT);

    }



}
