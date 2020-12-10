package ladder.domain.game;

import ladder.strategy.ConnectionStrategy;
import ladder.strategy.RandomConnectionStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        assertThat(Ladder.of(participants.getSize(), ()->false, height))
                .isEqualTo(Ladder.of(participants.getSize(), ()->false, height));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -2})
    void 사다리의_높이가_1이상이_아닐_때_예외(int inputHeight) {
        assertThatThrownBy(() -> Ladder.of(participants.getSize(), connectionStrategy, inputHeight))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Ladder.MESSAGE_LADDER_HEIGHT);

    }


    @Test
    void 참가자_한명의_결과값을_찾는다() {
        Ladder ladder = Ladder.of(Arrays.asList(
                Line.of(Arrays.asList(false, false, true)),
                Line.of(Arrays.asList(false, true, false)),
                Line.of(Arrays.asList(false, true, false))
        ));
        assertThat(ladder.move(0)).isEqualTo(0);
        assertThat(ladder.move(1)).isEqualTo(2);
        assertThat(ladder.move(2)).isEqualTo(1);
    }

}
