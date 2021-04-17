package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    @DisplayName("LadderCreationInformation 인스턴스 null 입력시 예외처리 여부 테스트")
    @Test
    void 검증_null() {
        // given
        People people = null;
        LadderHeight ladderHeight = LadderHeight.valueOf(5);

        // when
        assertThatThrownBy(()-> LadderCreationInformation.from(people, ladderHeight))
                .isInstanceOf(PeopleNullPointerException.class)
                .hasMessage("People 인스턴스가 null 입니다.");
    }
}