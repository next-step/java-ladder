package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    private Line line;

    @DisplayName("유저 사이즈 만큼 line생성")
    @Test
    public void createLines(){
        int userSize = 4;
        line = new Line(userSize);
        assertThat(line.getLines().size()).isEqualTo(userSize);

    }

}