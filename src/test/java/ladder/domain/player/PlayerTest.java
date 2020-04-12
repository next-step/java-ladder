package ladder.domain.player;

import ladder.model.player.Player;
import ladder.model.row.Position;
import ladder.model.row.Row;
import ladder.model.row.Rows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    private Player player;
    private Player player2;
    private Player player3;

    @BeforeEach
    void setUp() {
        player = new Player("Mark");
        player2 = new Player("Sujin");
        player3 = new Player("Yuqi");
    }

    @DisplayName("플레이어의 이름이 인자로 받은 이름과 같으면 true 반환, 아니면 false반환")
    @ParameterizedTest
    @CsvSource(value = {"Sujin:true","Shuha:false"}, delimiter = ':')
    void hasEqualNameTest(String name, boolean expected){
        assertThat(player2.hasEqualName(name)).isEqualTo(expected);
    }

    private Row createFirstRow() {
        Map<Position, Boolean> result = new HashMap<>();
        result.put(new Position(0), true);
        result.put(new Position(1), false);

        return new Row(result);
    }

    private Row createSecondRow() {
        Map<Position, Boolean> result = new HashMap<>();
        result.put(new Position(0), false);
        result.put(new Position(1), true);

        return new Row(result);
    }
}