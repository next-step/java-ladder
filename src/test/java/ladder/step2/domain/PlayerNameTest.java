package ladder.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerNameTest {
    public static final PlayerName JUN = new PlayerName("jun");
    public static final PlayerName POBI = new PlayerName("pobi");
    public static final PlayerName JK = new PlayerName("jk");
    public static final PlayerName HONUX = new PlayerName("honux");
    public static final PlayerName YOUNG = new PlayerName("young");
    
    @Test
    @DisplayName("플레이어 이름 5자 초과시 예외")
    void name_length_exceeded_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerName("abcdef"))
                .withMessage("플레이어 이름은 5자를 초과할 수 없습니다.");
    }
}
