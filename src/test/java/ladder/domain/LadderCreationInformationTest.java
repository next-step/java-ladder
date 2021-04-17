package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderCreationInformationTest {

    @DisplayName("LadderCreationInformation 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        People people = People.of("abcd,efgh,hijk".split(","));
        LadderHeight ladderHeight = LadderHeight.valueOf(5);

        // when
        LadderCreationInformation ladderCreationInformation = LadderCreationInformation.from(people, ladderHeight);

        // then
        assertThat(ladderCreationInformation).isNotNull();
    }
}