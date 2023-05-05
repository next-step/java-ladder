package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    @Test
    @DisplayName("가로 줄 생성 테스트")
    void createLinesTest() {
        List<String> names = List.of("a,b,c,d,e".split(","));
        Participants participants = Participants.from(names);
        Lines newLines = Lines.drawLines(participants, (index, previous) -> true);

        assertThat(newLines.numberOfLines())
                .isEqualTo(names.size());
    }

}
