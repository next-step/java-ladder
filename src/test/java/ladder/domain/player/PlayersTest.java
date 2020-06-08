package ladder.domain.player;

import ladder.domain.prize.Prizes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayersTest {

    private List<String> names;

    @BeforeEach
    void setUp() {
        names = new ArrayList<>();
        names.add("pobi");
        names.add("honux");

    }

    @DisplayName("null 이거나 0개의 이름이 입력되면 예외를 반환")
    @NullAndEmptySource
    @ParameterizedTest
    void createFailure(final List<String> names) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Players.of(names));
    }

    @DisplayName("이름 리스트로부터 여러 명의 Player 생성")
    @Test
    void create() {
        assertThat(Players.of(names).count())
                .isEqualTo(names.size());
    }

    @DisplayName("Players 의 모든 이름을 반환")
    @Test
    void getNames() {
        assertThat(Players.of(names).getNames())
                .isEqualTo(names);
    }
}
