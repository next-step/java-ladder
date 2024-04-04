package ladder;

import ladder.domain.Participant;
import ladder.domain.vo.Row;
import ladder.util.StringSplitter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

//    사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
//    사람 이름은 쉼표(,)를 기준으로 구분한다.
//    사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
//    사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
//|-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.

    @Test
    @DisplayName("참가자 이름 테스트")
    void participantNameTest(){
        Participant participant = new Participant("Jay");

        assertThat(participant.name()).isEqualTo("Jay");

        assertThatThrownBy(() ->
                new Participant("Achilles")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최대 5글자 입니다.");

    }

    @Test
    @DisplayName("쉼표 구분 테스트")
    void splitWithCommaTest(){
        List<String> names = StringSplitter.splitWithComma("jay,kim,lee");

        assertThat(names).hasSize(3);
        assertThat(names).containsExactlyInAnyOrder("jay", "kim", "lee");
    }

    @Test
    @DisplayName("열 생성 테스트")
    void rowTest(){

        Row row = new Row(5);

        assertThat(row.width()).isEqualTo(5);

        assertThatThrownBy(() ->
                new Row(6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("길이는 5가 최대입니다.");

    }

}
