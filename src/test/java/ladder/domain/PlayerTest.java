package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerTest {

    @DisplayName("이름이 5자 초과면 Name 생성 실패")
    @Test
    void create_fail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player("chicken", new Position(0)))
                .withMessage("이름은 5자이하 이어야 합니다");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0,1",
            "1,0",
            "2,2",
            "3,4",
            "4,3"
    })
    void move(Integer position, Integer expected) {
        Player player = new Player("panda", new Position(position));
        List<Boolean> bridges = List.of(true, false, false, true);
        Line line = new Line(bridges);

        assertThat(player.move(line)).isEqualTo(new Player("panda", new Position(expected)));
    }
}
