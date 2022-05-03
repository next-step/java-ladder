package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameResultTest {


    @Test
    void findPrizeByName() {
        LadderGameResult result = new LadderGameResult();

        result.put(new Participant("a"), new Prize("0"));
        result.put(new Participant("b"), new Prize("1"));
        result.put(new Participant("c"), new Prize("2"));

        assertThat(result.findPrizeByName("a")).isEqualTo("0");
    }

    @DisplayName("게임 결과가 없는 참여자 이름으로 조회하면 예외")
    @Test
    void GivenNonExistingName_findPrizeByName_ThrowsNoSuchElementException() {
        LadderGameResult result = new LadderGameResult();

        result.put(new Participant("a"), new Prize("0"));
        result.put(new Participant("b"), new Prize("1"));
        result.put(new Participant("c"), new Prize("2"));

        assertThatThrownBy(() -> result.findPrizeByName("d"))
                .isInstanceOf(NoSuchElementException.class);
    }
}
