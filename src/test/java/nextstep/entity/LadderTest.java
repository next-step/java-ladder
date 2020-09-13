package nextstep.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

class LadderTest {

    @Test
    @DisplayName("인원이 1인 경우 사다리 라인 상태 반환 메소드 검증")
    void getLinesStatus() {
        Personnel personnel = Personnel.of(1);
        Length length = Length.of(1);
        List<List<Boolean>> expected = Collections.singletonList(Collections.singletonList(Boolean.FALSE));
        Ladder ladder = Ladder.of();
        ladder.initLadder(personnel, length);
        then(ladder.getLinesStatus()).isEqualTo(expected);
    }

    @Test
    @DisplayName("인원이 1인 경우 게임 결과 검증")
    void play() {
        Personnel personnel = Personnel.of(1);
        Length length = Length.of(1);
        Ladder ladder = Ladder.of();
        ladder.initLadder(personnel, length);

        then(ladder.play(0)).isEqualTo(0);
    }
}
