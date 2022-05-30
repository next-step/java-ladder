package ladder.domain;

import ladder.constant.Type;
import ladder.exception.InvalidCountOfPositionException;
import ladder.exception.NotFoundPositionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionsTest {

    @Test
    @DisplayName("참가자 수는 2 이상이여야 한다.")
    void invalidCount() {
        assertThatThrownBy(() -> Positions.createPlayers(new String[]{"tom"}))
                .isInstanceOf(InvalidCountOfPositionException.class)
                .hasMessage("참가자의 수는 2 이상이여야 합니다.");
    }

    @Test
    @DisplayName("총 필요한 좌표 개수는 사람의 수보다 1 작다.")
    void totalPoint() {
        assertThat(Positions.createPlayers(new String[]{"tom", "tommy", "paul"}).pointCount()).isEqualTo(2);
        assertThat(Positions.createResults(new String[]{"tom", "tommy", "paul"}).pointCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("이름들의 크기 중 가장 큰 크기의 값을 반환한다.")
    void maxNameSize() {
        assertThat(Positions.createPlayers(new String[]{"tom", "tommy", "paul"}).maxNameSize()).isEqualTo(5);
        assertThat(Positions.createResults(new String[]{"tom", "tommy", "paul"}).maxNameSize()).isEqualTo(5);
        assertThat(Positions.createPlayers(new String[]{"tom", "안녕하세요", "paul"}).maxNameSize()).isEqualTo(10);
        assertThat(Positions.createResults(new String[]{"tom", "안녕하세요", "paul"}).maxNameSize()).isEqualTo(10);
    }

    @Test
    @DisplayName("Type.FIXED Position 을 가지고 있는 Positions 중 해당하는 이름의 Position 를 반환한다.")
    void searchName() {
        Positions positions = new Positions(List.of(PositionTest.FIXED_1000_ZERO_INDEX, PositionTest.FIXED_FAIL_ONE_INDEX));

        assertThat(positions.value(NameTest.NAME_1000)).isEqualTo(PositionTest.FIXED_1000_ZERO_INDEX);
        assertThat(positions.value(NameTest.NAME_FAIL)).isEqualTo(PositionTest.FIXED_FAIL_ONE_INDEX);
    }

    @Test
    @DisplayName("해당하는 이름의 Position아 존재하지 않을 경우 NotFoundPosition를 반환한다.")
    void invalidSearchName() {
        Positions positions = new Positions(List.of(PositionTest.FIXED_1000_ZERO_INDEX, PositionTest.FIXED_FAIL_ONE_INDEX));

        assertThatThrownBy(() -> positions.value(new Name("anna")))
                .isInstanceOf(NotFoundPositionException.class)
                .hasMessage("anna를 찾을 수 없습니다.");
    }

    @Test
    @DisplayName("해당하는 위치값을 가진 Element를 반환한다.")
    void searchPosition() {
        Positions positions = new Positions(List.of(PositionTest.FIXED_1000_ZERO_INDEX, PositionTest.FIXED_FAIL_ONE_INDEX));

        assertThat(positions.value(IndexTest.ZERO_INDEX)).isEqualTo(PositionTest.FIXED_1000_ZERO_INDEX);
        assertThat(positions.value(IndexTest.ONE_INDEX)).isEqualTo(PositionTest.FIXED_FAIL_ONE_INDEX);
    }
}