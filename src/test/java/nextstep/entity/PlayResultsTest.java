package nextstep.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.BDDAssertions.then;

class PlayResultsTest {

    @Test
    @DisplayName("게임 도착 지점 반환 메소드 검증")
    void findArrivalName() {
        String entryName = "ent";
        String arrivalName = "arr";
        PlayResults playResults = PlayResults.of(Collections.singletonList(PlayResult.of(entryName, arrivalName)));
        then(playResults.findArrivalName(entryName)).isEqualTo(arrivalName);
    }
}
