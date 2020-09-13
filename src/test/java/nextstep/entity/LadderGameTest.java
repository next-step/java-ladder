package nextstep.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

class LadderGameTest {

    @Test
    @DisplayName("사다리 라인 상태 반환 메소드 검증")
    void getLinesStatus() {
        String entryName = "ent";
        Entries startEntries = Entries.of(Collections.singletonList(entryName));
        Length length = Length.of(1);

        LadderGame ladderGame = LadderGame.of(startEntries);
        ladderGame.initLadder(length);

        List<List<Boolean>> expected = Collections.singletonList(Collections.singletonList(Boolean.FALSE));
        then(ladderGame.getLinesStatus()).isEqualTo(expected);
    }

    @Test
    @DisplayName("게임 결과 반환 메소드 검증")
    void play() {
        String entryName = "ent";
        String arrivalName = "arr";
        Entries startEntries = Entries.of(Collections.singletonList(entryName));
        Length length = Length.of(1);

        LadderGame ladderGame = LadderGame.of(startEntries);
        ladderGame.initLadder(length);

        Entries arrivalEntries = Entries.of(Collections.singletonList(arrivalName));
        then(ladderGame.play(Entry.of(entryName), arrivalEntries)).isEqualTo(Entry.of(arrivalName));
    }
}
