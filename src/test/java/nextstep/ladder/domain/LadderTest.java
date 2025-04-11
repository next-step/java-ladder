package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    @Test
    @DisplayName("기본 생성자 동작 확인")
    void create() {
        Participants participants = new Participants(new String[]{"p1", "p2", "p3"});

        List<Bridge> bridge1 = List.of(new Bridge(true), new Bridge(false));
        List<Bridge> bridge2 = List.of(new Bridge(false), new Bridge(true));
        List<LadderLine> ladderLines = new ArrayList<>();
        ladderLines.add(new LadderLine(bridge1));
        ladderLines.add(new LadderLine(bridge2));

        Ladder ladder = new Ladder(participants, ladderLines);

        assertThat(ladder.getNames()).isEqualTo(participants.getNames());
        assertThat(ladder.getLines()).isEqualTo(ladderLines);
    }

    @Test
    @DisplayName("기본 생성자에 참여자 숫자와 맞지 않는 사다리 입력시 동작 확인 - 예외 발생")
    void create_with_no_match_participants_and_lines() {
        Participants participants = new Participants(new String[]{"p1", "p2", "p3"});

        List<LadderLine> ladderLines = new ArrayList<>();
        ladderLines.add(LadderLine.generate(2));
        ladderLines.add(LadderLine.generate(3));

        assertThatThrownBy(() -> new Ladder(participants, ladderLines))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Ladder.NO_MATCH_LADDER_SIZE_WITH_PARTICIPANTS);
    }

    @Test
    @DisplayName("사다리 generate 정상 동작 확인")
    void generate() {
        assertThat(Ladder.generate(5, new String[]{"p1", "p2", "p3"})).isInstanceOf(Ladder.class);
        assertThat(Ladder.generate(5, new String[]{"p1", "p2", "p3"}).getLines().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("참여자 이름 저장 및 가져오기 기능 확인")
    void names_test() {
        String[] names = {"p1", "p2", "p3"};
        assertThat(Ladder.generate(5, names).getNames()).isEqualTo(new Participants(names).getNames());
    }
}
