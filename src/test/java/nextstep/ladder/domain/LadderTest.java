package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    @Test
    @DisplayName("기본 생성자 동작 확인")
    void create() {
        List<Bridge> bridge1 = List.of(new Bridge(true), new Bridge(false));
        List<Bridge> bridge2 = List.of(new Bridge(false), new Bridge(true));
        List<LadderLine> ladderLines = new ArrayList<>();
        ladderLines.add(new LadderLine(bridge1));
        ladderLines.add(new LadderLine(bridge2));

        Ladder ladder = new Ladder(ladderLines);
        assertThat(ladder.getLines()).isEqualTo(ladderLines);
    }

    @Test
    @DisplayName("기본 생성자에 참여자 숫자와 맞지 않는 사다리 입력시 동작 확인 - 예외 발생")
    void create_with_no_match_participants_and_lines() {
        List<LadderLine> ladderLines = new ArrayList<>();
        ladderLines.add(LadderLine.generate(2));
        ladderLines.add(LadderLine.generate(3));

        assertThatThrownBy(() -> new Ladder(ladderLines))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Ladder.NOT_ALL_MATCH_LADDER_SIZE);
    }

    @Test
    @DisplayName("사다리 generate 정상 동작 확인")
    void generate() {
        assertThat(Ladder.generate(5, 2)).isInstanceOf(Ladder.class);
        assertThat(Ladder.generate(5, 2).getLines().size()).isEqualTo(5);
    }
}
