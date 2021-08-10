package nextstep.ladder.domain.laddar;

import nextstep.ladder.fixture.LadderFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static nextstep.ladder.fixture.LadderFixture.WIDTH_SIZE_FIXTURE;

/**
 * LadderRow는 사다리의 행에 대한 정보를 가지며, 여러개의 열을 포함한다.
 */
class LadderRowTest {
    @Test
    @DisplayName("가지고 있는 모든 열의 정보를 List<Boolean>으로 반환한다. 오른쪽과 이어져있다면 true, 아니면 false이다. 픽스처는 5의 크기로 초기화 되었다.")
    void toDirections() {
        LadderRow ladderRow = LadderRow.from(LadderFixture.LADDER_GAME_CONFIG);
        List<Boolean> directions = ladderRow.toDirections();
        Assertions.assertThat(directions.size()).isEqualTo(WIDTH_SIZE_FIXTURE);
    }
}
