package ladder.domain;

import ladder.exception.LadderHeightNullPointerException;
import ladder.exception.PeopleNullPointerException;
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

    @DisplayName("LadderCreationInformation 인스턴스 null 인 People 인스턴스에 입력시 예외처리 여부 테스트")
    @Test
    void 검증_People_null() {
        // given
        People people = null;
        LadderHeight ladderHeight = LadderHeight.valueOf(5);

        // when
        assertThatThrownBy(()-> LadderCreationInformation.from(people, ladderHeight))
                .isInstanceOf(PeopleNullPointerException.class)
                .hasMessage("People 인스턴스가 null 입니다.");
    }

    @DisplayName("LadderCreationInformation 인스턴스 null 인 ladderHeight 인스턴스에 입력시 예외처리 여부 테스트")
    @Test
    void 검증_LadderHeight_null() {
        // given
        People people = People.of("abcd,efgh,hijk".split(","));
        LadderHeight ladderHeight = null;

        // when
        assertThatThrownBy(()-> LadderCreationInformation.from(people, ladderHeight))
                .isInstanceOf(LadderHeightNullPointerException.class)
                .hasMessage("LadderHeight 인스턴스가 null 입니다.");
    }


    @DisplayName("LadderCreationInformation 인스턴스가 사다리 가로 정보 반환 여부 테스트")
    @Test
    void 반환_width() {
        // given
        String names = "abcd,efgh,hijk";
        int expected = names.length();
        People people = People.of(names.split(","));
        LadderHeight ladderHeight = LadderHeight.valueOf(5);

        // when
        LadderCreationInformation ladderCreationInformation = LadderCreationInformation.from(people, ladderHeight);
        int actual = ladderCreationInformation.row();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}