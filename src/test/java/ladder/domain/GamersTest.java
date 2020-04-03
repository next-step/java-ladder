package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GamersTest {
    @Test
    @DisplayName(",로 이름들 받아서 생성")
    void getNameTest() {
        String name = "unit0, unit1, unit2 ,unit3,unit4";
        assertThat(Gamers.ofComma(name).getGamerList())
                .hasSize(5);
    }
}
