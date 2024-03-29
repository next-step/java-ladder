package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @Test
    @DisplayName("매개변수로 넘어오는 Name과 Position을 Player의 불변 필드로 하여 정상 생성")
    void from() {
        Name name = Name.from("abcde");
        Position position = Position.valueOf(0);
        assertThat(Player.of(name, position)).isNotNull().isEqualTo(Player.of(name, position));
    }
}
