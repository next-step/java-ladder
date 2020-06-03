package ladder.domain.dto;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

public class StairDtoTest {

    private Ladder ladder;

    @BeforeEach
    void setUp() {
        List<String> names = new ArrayList<>();
        names.add("pobi");
        names.add("honux");

        this.ladder = Ladder.of(Height.of(5), names.size());
    }

    @DisplayName("사다리 정보로 각 행의 좌->우로의 계단 라인 정보 리스트 반환")
    @Test
    void create() {
        assertThatCode(() -> StairDto.from(ladder))
                .doesNotThrowAnyException();
    }
}
