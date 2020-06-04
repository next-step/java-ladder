package ladder.domain.dto;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.PillarCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("인자로 지정한 높이 만큼 StairDto 리스트가 생성")
    @ParameterizedTest
    @ValueSource(ints = { Height.MIN_HEIGHT, Height.MIN_HEIGHT * 5 })
    void getLines(final int height) {
        Ladder ladder = Ladder.of(Height.of(height), PillarCount.MIN_COUNT);

        assertThat(StairDto.from(ladder).size())
                .isEqualTo(height);
    }

    @DisplayName("한 명의 참여자로 게임을 실행하면 모든 높이의 기둥에 존재하는 계단 수는 0개")
    @Test
    void isSinglePillar() {
        Ladder ladder = Ladder.of(Height.of(Height.MIN_HEIGHT * 5), PillarCount.MIN_COUNT);

        StairDto.from(ladder)
                .forEach(stairDto -> assertThat(stairDto.isSinglePillar()).isEqualTo(true));
    }
}
