package nextstep.ladder.domain.element;

import nextstep.ladder.domain.dto.LadderFigure;
import nextstep.ladder.domain.info.LadderInfo;
import nextstep.ladder.domain.info.LadderSize;
import nextstep.ladder.domain.play.PlayResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static nextstep.ladder.fixture.Fixture.CREATE_STRATEGY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderTest {
    @DisplayName("LadderInfo와 함께 Ladder 생성한다")
    @Test
    public void make_Ladder() throws Exception {
        //arrange
        LadderSize ladderSize = LadderSize.of(1, 1);
        LadderInfo ladderInfo = LadderInfo.of(ladderSize, CREATE_STRATEGY);

        //act
        Ladder ladder = Ladder.create(ladderInfo);

        //assert
        assertThat(ladder).isInstanceOf(Ladder.class);
    }

    @DisplayName("Ladder생성시 LadderInfo가 null이면 IllegalArgumentException을 반환한다")
    @Test
    public void throw_exception_when_ladderinfo_is_null() throws Exception {
        //arrange, act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> Ladder.create(null));
    }

    @DisplayName("Ladder Line을 LadderFigure로 래핑해서 return한다 ")
    @Test
    public void should_return_ladder_plane_figures() throws Exception {
        //arrange
        LadderSize ladderSize = LadderSize.of(3, 5);
        LadderInfo ladderInfo = LadderInfo.of(ladderSize, CREATE_STRATEGY);
        Ladder ladder = Ladder.create(ladderInfo);

        //act
        List<LadderFigure> ladderFigures = ladder.getFigures();

        //assert
        assertThat(ladderFigures.get(0).getLines()).contains(true, false);
    }

    @DisplayName("Ladder move움직임에대한 PlayResult를 반환한다 ")
    @Test
    public void should_return_play_result() throws Exception {
        //arrange
        LadderSize ladderSize = LadderSize.of(3, 5);
        LadderInfo ladderInfo = LadderInfo.of(ladderSize, CREATE_STRATEGY);
        Ladder ladder = Ladder.create(ladderInfo);

        //act
        PlayResult playResult = ladder.move();

        //assert
        assertThat(playResult).isInstanceOf(PlayResult.class);
    }
}