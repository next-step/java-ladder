package laddergame.domain.player;

import laddergame.domain.vo.Column;
import laddergame.domain.vo.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @DisplayName("참가자는 이름과 시작 열번호를 생성자로 받아 생성한다.")
    @ParameterizedTest
    @CsvSource({"pobi, 1", "crong, 2", "hoto, 3"})
    void createPlayer(String name, int column) {
        Player player = new Player(name, column);

        assertAll(
                () -> assertThat(player.getName()).isEqualTo(name),
                () -> assertThat(player.getColumn()).isEqualTo(new Column(column))
        );
    }

    @DisplayName("인자로 받은 String이 자신의 이름과 같은지 비교")
    @ParameterizedTest
    @CsvSource({"pobi, true", "crong, false"})
    void isSameName(String sameName, boolean result) {
        Player player = new Player("pobi", 1);
        Name name = new Name(sameName);
        assertThat(player.isSameName(name)).isEqualTo(result);
    }
}
