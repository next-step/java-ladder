package nextstep.ladder.domain.laddar;

import nextstep.ladder.domain.dto.RowDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static nextstep.ladder.fixture.LadderFixture.HEIGHT_SIZE_FIXTURE;
import static nextstep.ladder.fixture.LadderFixture.LADDER_GAME_CONTEXT;

/**
 * Ladder는 사다리게임의 사다리를 의미한다. 사다리의 모든 행에 대한 정보를 갖는다.
 */
class LadderTest {
    @Test
    @DisplayName("가지고있는 모든 행의 정보를 DTO 객체로 변환하여 반환한다. 픽스처는 5의 크기로 초기화 되었다.")
    void convert() {
        Ladder ladder = Ladder.from(LADDER_GAME_CONTEXT);
        List<RowDto> rowDtos = ladder.rowInfos();
        Assertions.assertThat(rowDtos.size()).isEqualTo(HEIGHT_SIZE_FIXTURE);
    }
}
