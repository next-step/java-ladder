package ladder.domain.dto;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LadderShapeResultTest {

    private List<String> names;
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        this.names = new ArrayList<>();
        names.add("pobi");
        names.add("honux");

        this.ladder = Ladder.of(Height.of(5), names.size());
    }

    @DisplayName("게임 참여자 이름과 사다리 판의 정보를 가진 LadderShapeResult 를 반환")
    @Test
    void create() {
        assertThatCode(() -> LadderShapeResult.of(names, StairDto.from(ladder)))
                .doesNotThrowAnyException();
    }

    @DisplayName("인자로 넣은 게임 참여자의 정보를 반환")
    @Test
    void getPlayerNames() {
        assertThat(LadderShapeResult.of(names, StairDto.from(ladder))
                .getPlayerNames())
                .isEqualTo(names);
    }
}
