package ladder.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    public static final Position POSITION = new Position(2);
    
    @Test
    @DisplayName("포지션 생성")
    void create() {
        assertThat(POSITION).isNotNull();
    }
    
    @Test
    @DisplayName("포지션 가져오기")
    void get_position() {
        assertThat(POSITION.getPosition()).isEqualTo(2);
    }
}