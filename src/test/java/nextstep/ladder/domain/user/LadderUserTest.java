package nextstep.ladder.domain.user;

import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.Point;
import nextstep.ladder.domain.prize.LadderPrize;
import nextstep.ladder.domain.prize.LadderPrizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LadderUserTest {

    @DisplayName("LadderUser 인스턴스 만들기")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new LadderUser("jk", 0));
    }

    @DisplayName("유저 이름이 5자가 넘어가면 User 생성자 호출시 예외를 반환")
    @Test
    public void testConstructor_throwException() {
        assertThatThrownBy(() -> new LadderUser("testUser1", 0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름은 최대 5자를 넘을 수 없습니다.");
    }

    @DisplayName("이동 성공")
    @Test
    public void testMove() {
        LadderUser ladderUser = new LadderUser("jk", 0);
        Line line = new Line(List.of(new Point(true), new Point(false)));

        assertThat(ladderUser.move(line)).isEqualTo(new LadderUser("jk", 1));
    }

    @DisplayName("이동 실패")
    @Test
    public void testNotMove() {
        LadderUser ladderUser1 = new LadderUser("jk", 0);
        LadderUser ladderUser2 = new LadderUser("jk", 1);
        LadderUser ladderUser3 = new LadderUser("jk", 2);
        Line line = new Line(List.of(new Point(false), new Point(false)));

        assertAll(
            () -> assertThat(ladderUser1.move(line)).isEqualTo(new LadderUser("jk", 0)),
            () -> assertThat(ladderUser2.move(line)).isEqualTo(new LadderUser("jk", 1)),
            () -> assertThat(ladderUser3.move(line)).isEqualTo(new LadderUser("jk", 2))
        );
    }

    @DisplayName("위치에 따른 Prize 선택")
    @Test
    public void testSelect() {
        LadderUser ladderUser = new LadderUser("jk", 1);

        LadderPrizes ladderPrizes = new LadderPrizes(List.of(new LadderPrize("1000"), new LadderPrize("꽝")));
        assertThat(ladderUser.select(ladderPrizes)).isEqualTo(new LadderPrize("꽝"));
    }
}
