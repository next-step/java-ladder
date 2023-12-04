package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RealLadderTest {
    @Test
    void move_success() {
        Brace firstLine_brace1 = new Brace(false, true);
        Brace firstLine_brace2 = new Brace(true, false);
        Brace firstLine_brace3 = new Brace(false, false);
        Brace firstLine_brace4 = new Brace(false, false);
        RealLine firstLine = new RealLine(List.of(firstLine_brace1, firstLine_brace2, firstLine_brace3, firstLine_brace4));
        assertThat(firstLine.move(0)).isEqualTo(1);
        assertThat(firstLine.move(1)).isEqualTo(0);
        assertThat(firstLine.move(2)).isEqualTo(2);
        assertThat(firstLine.move(3)).isEqualTo(3);
    }
}
