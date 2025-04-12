package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantTest {
    @Test
    @DisplayName("위치 정보를 가진 생성 케이스 테스트")
    void create_with_position() {
        assertThat(new Participant("test", 1).position()).isEqualTo(1);
    }

    @Test
    @DisplayName("참여자 위치에 연결된 bridge가 있는 경우 move 호출시 위치 정보 변경 확인")
    void move_test() {
        Participant participant = new Participant("test", 0);
        LadderLine line = new LadderLine(List.of(new Bridge(true), new Bridge(false)));
        participant.move(line);
        assertThat(participant).isEqualTo(new Participant("test", 1));
    }
}
