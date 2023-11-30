package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

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

    @ParameterizedTest(name = "i-1 이 연결되어 있다면 참가자의 위치는 i-1 이 됩니다.")
    @CsvSource(value = {"1, 0", "3, 2"})
    void goLeft(int current, int result) {
        // given
        Participator participator = new Participator("test", current);
        // when
        participator.goLadderOneLine(new Line(List.of(WidthStatus.connected, WidthStatus.notConnected, WidthStatus.connected)));
        // then
        assertThat(participator.getLocation()).isEqualTo(result);
    }

    @ParameterizedTest(name = "i 가 연결되어 있다면 참가자의 위치는 i+1 이 됩니다.")
    @CsvSource(value = {"0, 1", "2, 3"})
    void goRight(int current, int result) {
        // given
        Participator participator = new Participator("test", current);
        // when
        participator.goLadderOneLine(new Line(List.of(WidthStatus.connected, WidthStatus.notConnected, WidthStatus.connected)));
        // then
        assertThat(participator.getLocation()).isEqualTo(result);
    }

    @ParameterizedTest(name = "둘 다 연결되어 있지 않다면 참가자의 위치는 i가 됩니다.")
    @CsvSource(value = {"2, 2", "3, 3"})
    void goStraight(int current, int result) {
        // given
        Participator participator = new Participator("test", current);
        // when
        participator.goLadderOneLine(new Line(List.of(WidthStatus.connected, WidthStatus.notConnected, WidthStatus.notConnected)));
        // then
        assertThat(participator.getLocation()).isEqualTo(result);
    }

}