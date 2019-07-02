package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GamerTest {
    private static final String GAMER_NAMES = "pobi,honux,crong,jk";

    @Test
    void 정상참여자_두명구하기() {
        Gamer gamer = new Gamer(GAMER_NAMES);
        assertThat(gamer.getNames().size()).isEqualTo(4);
    }

    @Test
    void 비정상참여자_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Gamer gamerOverLength = new Gamer("pobi,honuxu");
            Gamer gamerIsBlank = new Gamer("pobi, ");
            Gamer gamerOnlyOne = new Gamer("pobo");
        });
    }
}
