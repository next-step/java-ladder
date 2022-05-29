package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;

public class LadderTest {
    @DisplayName("높이만큼 사다리를 만든다.")
    @Test
    public void create() {
        final Height height = new Height(3);
        final Ladder ladder = new Ladder(4, height);
        final ArrayList<Line> lines = ladder.makeLadder(() -> true);

        assertThat(ladder.isMaxHeight(height)).isTrue();

        lines.forEach(line -> {
            for (int i = 0; i < line.getMaxPointPosition(); i++) {
                if (line.hasBridge(i)) {
                    System.out.print("|-----|");
                } else {
                    System.out.print("|     |");
                }
            }
            System.out.println();
        });
    }

}
