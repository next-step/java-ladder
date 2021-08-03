package nextstep.ladder.domain.element;

import nextstep.ladder.domain.info.LadderInfo;
import nextstep.ladder.domain.info.LadderSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlaneTest {
    @DisplayName("LadderInfo와 함께 Plane 생성한다")
    @Test
    public void make_Plane() throws Exception {
        //arrange
        LadderSize ladderSize = LadderSize.of(1, 1);
        LadderInfo ladderInfo = LadderInfo.of(ladderSize);

        //act
        Plane plane = Plane.create(ladderInfo);

        //assert
        assertThat(plane).isInstanceOf(Plane.class);
    }

    @DisplayName("Plane생성시 LadderInfo가 null이면 IllegalArgumentException을 반환한다")
    @Test
    public void throw_exception_when_ladderinfo_is_null() throws Exception {
        //arrange, act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> Plane.create(null));
    }

    @DisplayName("Plane가 Right Line이 있는경우 true 를 반환한다")
    @Test
    public void should_return_lines() throws Exception {
        //arrange
        LadderSize ladderSize = LadderSize.of(3, 5);
        LadderInfo ladderInfo = LadderInfo.of(ladderSize);
        Plane plane = Plane.create(ladderInfo);

        //act
        List<Boolean> planeLines = plane.getLines();

        //assert
        assertThat(planeLines).contains(true, false);
    }
}