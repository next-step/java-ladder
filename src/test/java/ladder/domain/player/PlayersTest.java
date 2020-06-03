package ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayersTest {

    @DisplayName("null 이거나 0개의 이름이 입력되면 예외를 반환")
    @Test
    void createFailure() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Players.of(null));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Players.of(new ArrayList<>()));
    }

    @DisplayName("이름 리스트로부터 여러 명의 Player 생성")
    @Test
    void create() {
        List<String> names = new ArrayList<>();
        names.add("pobi");
        names.add("honux");

        assertThatCode(() -> Players.of(names))
                .doesNotThrowAnyException();
    }
}
