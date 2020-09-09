package nextstep.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class PlayResultTest {

    @Test
    @DisplayName("출발 지점 동등 비교 검증")
    void isEqualEntry() {
        String entryName = "ent";
        String arrivalName = "arr";
        then(PlayResult.of(entryName, arrivalName).isEqualEntry(entryName)).isTrue();
        then(PlayResult.of(entryName, arrivalName).isEqualEntry(arrivalName)).isFalse();
    }

    @Test
    @DisplayName("도착 지점 반환 메소드 검증")
    void getArrivalName() {
        String entryName = "ent";
        String arrivalName = "arr";
        then(PlayResult.of(entryName, arrivalName).getArrivalName()).isEqualTo(arrivalName);
    }
}
