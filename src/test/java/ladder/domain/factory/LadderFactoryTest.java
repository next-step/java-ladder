package ladder.domain.factory;

import ladder.domain.engine.Ladder;
import ladder.domain.engine.LadderCreator;
import ladder.domain.engine.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderFactoryTest {
    public static final String POBI_HONUX_CRONG_JK = "pobi,honux,crong,jk";
    public static final int VERTICAL_HEIGHT = 5;

    @Test
    @DisplayName("ns 사다리 생성")
    void create_ns() {
        LadderCreator ladderCreator = LadderFactory.createNsLadderCreator();

        Ladder ladder = ladderCreator.create(new Players(POBI_HONUX_CRONG_JK), VERTICAL_HEIGHT);
        int actual = ladder.getLines()
                .getLines()
                .size();

        assertThat(actual).isEqualTo(VERTICAL_HEIGHT);
    }
}
