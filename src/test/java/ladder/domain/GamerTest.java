package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GamerTest {
    private static final String GAMER_NAME = "pobi,honux,crong,jk";
    private Gamer gamer;

    @BeforeEach
    void setUp() {
        gamer = Gamer.nameOf(GAMER_NAME);
    }

    @Test
    void 정상참여자_두명구하기() {
        assertThat(gamer.getNames().size()).isEqualTo(4);
    }

    @Test
    void 비정상참여자_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Gamer gamerOverLength = Gamer.nameOf("pobi,honuxu");
            Gamer gamerIsBlank = Gamer.nameOf("pobi, ");
            Gamer gamerOnlyOne = Gamer.nameOf("pobo");
        });
    }

    @Test
    void 게이머이름출력() {
        gamer.getNames().stream().forEach(System.out::println);
    }
}
