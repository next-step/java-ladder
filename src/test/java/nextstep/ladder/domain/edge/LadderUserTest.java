package nextstep.ladder.domain.edge;

import nextstep.ladder.domain.line.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

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

    @DisplayName("line에 따라 이동")
    @Test
    public void testMove() {
        LadderUser ladderUser = new LadderUser("jk", 0);
        Line line = new Line(List.of(new Point(true), new Point(false)));

        assertThat(ladderUser.move(line)).isEqualTo(new LadderUser("jk", 1));
    }

    @DisplayName("line이 없어 이동하지 않음")
    @Test
    public void testNotMove() {
        LadderUser ladderUser1 = new LadderUser("jk", 0);
        LadderUser ladderUser2 = new LadderUser("jk", 1);
        LadderUser ladderUser3 = new LadderUser("jk",2);
        Line line = new Line(List.of(new Point(false), new Point(false)));

        assertAll(
            () -> assertThat(ladderUser1.move(line)).isEqualTo(new LadderUser("jk", 0)),
            () -> assertThat(ladderUser2.move(line)).isEqualTo(new LadderUser("jk", 1)),
            () -> assertThat(ladderUser3.move(line)).isEqualTo(new LadderUser("jk", 2))
        );
    }
}
