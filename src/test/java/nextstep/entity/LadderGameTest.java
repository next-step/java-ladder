package nextstep.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

class LadderGameTest {

    private String entryName;
    private LadderGame ladderGame;

    @BeforeEach
    public void setUp() {
        entryName = "ent";
        Length length = Length.of(1);

        ladderGame = LadderGame.of(Collections.singletonList(entryName), length);
    }

    @Test
    @DisplayName("사다리 라인 상태 반환 메소드 검증")
    void getLinesStatus() {
        List<List<Boolean>> expected = Collections.singletonList(Collections.singletonList(Boolean.FALSE));
        then(ladderGame.getLinesStatus()).isEqualTo(expected);
    }

    @Test
    @DisplayName("게임 결과 반환 메소드 검증")
    void play() {
        String arrivalName = "arr";
        then(ladderGame.play(entryName, Collections.singletonList(arrivalName))).isEqualTo(Entry.of(arrivalName));
    }
}
