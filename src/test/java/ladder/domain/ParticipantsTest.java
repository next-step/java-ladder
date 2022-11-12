package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantsTest {

    @Test
    @DisplayName("빈 값을 할당하는 경우 Participants 객체를 생성하는데 실패한다.")
    void create_with_empty_value() {
        assertThatThrownBy(() -> new Participants("")).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("입력 값이 누락되었습니다.");
    }

    @Test
    @DisplayName("참여자가 한 사람 이하인 경우 Participants 객체를 생성하는데 실패한다.")
    void create_with_one_person() {
        assertThatThrownBy(() -> new Participants("jordy")).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("두 사람 이상 참여해야 합니다.");
    }

    @Test
    @DisplayName("size 메소드는 참여자의 수를 반환한다.")
    void size() {
        Participants participants = new Participants("jordy,penda,kero");
        assertThat(participants.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("move 메소드는 참여자의 위치를 이동시킨다.")
    void move() {
        Participants participants = new Participants("jordy,penda,kero,cobb");
        List<Integer> positions = List.of(1, 0, 3, 2);
        participants.move(positions);

        String[] splited = "jordy,penda,kero,cobb".split(",");
        List<Participant> value = participants.getValue();
        IntStream.range(0, participants.size()).forEach(i -> {
            assertThat(value.get(i)).isEqualTo(new Participant(splited[i], positions.get(i)));
        });
    }

    @Test
    @DisplayName("findByName 메소드는 입력된 이름을 가진 Participant 객체를 찾아 반환한다.")
    void findByName() {
        Participants participants = new Participants("jordy,penda,kero,cobb");
        assertThat(participants.findByName("jordy")).isEqualTo(new Participant("jordy", 0));
    }

    @Test
    @DisplayName("findByName 메소드에 존재하지 않는 참여자의 이름을 입력하면 실패한다.")
    void findByName_with_not_found() {
        Participants participants = new Participants("jordy,penda,kero,cobb");
        assertThatThrownBy(() -> participants.findByName("jordy"))
            .isInstanceOf(NoSuchElementException.class)
            .hasMessage("존재하지 않는 사용자입니다.");
    }
}
