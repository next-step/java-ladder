package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipatorTest {

    @DisplayName("5글자가 넘는 사람이름을 입력받아도 앞에서부터 5글자만 부여합니다.")
    @Test
    void fiveName() {
        // given
        String inputName = "javajigi";
        // when
        Participator participator = new Participator(inputName, 1);
        // then
        assertThat(participator).isEqualTo(new Participator("javaj", 1));
    }

    @DisplayName("이름을 출력할 때 5글자 미만이라면 앞 뒤 공백을 포함해 6글자로 만들어줍니다")
    @Test
    void makeFullName() {
        // given
        Participator participator = new Participator("j", 1);
        // when
        String result = participator.makeFullName();
        // then
        assertThat(result).isEqualTo("    j ");
        assertThat(result.length()).isEqualTo(6);
    }

    @DisplayName("이름을 출력할때 5글자라면 앞에 공백만 추가합니다.")
    @Test
    void makeFullNameFive() {
        // given
        Participator participator = new Participator("honux", 1);
        // when
        String result = participator.makeFullName();
        // then
        assertThat(result).isEqualTo(" honux");
        assertThat(result.length()).isEqualTo(6);
    }

    @DisplayName("이름이 있는지 확인하는 메서드")
    @Test
    void hasName() {
        // given
        Participator participator = new Participator("test", 1);
        // when
        boolean result1 = participator.hasName("test");
        boolean result2 = participator.hasName("test2");
        // then
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
    }

    @DisplayName("사다리에서 왼쪽으로 이동합니다.")
    @Test
    void goLeft() {
        // given
        Participator participator = new Participator("test", 1);
        // when
        participator.goLeft();
        // then
        assertThat(participator.getLocation()).isEqualTo(0);
    }

    @DisplayName("사다리에서 오른쪽으로 이동합니다.")
    @Test
    void goRight() {
        // given
        Participator participator = new Participator("test", 1);
        // when
        participator.goRight();
        // then
        assertThat(participator.getLocation()).isEqualTo(2);
    }

}