package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderExecutorTest {

    Participants participants;

    @BeforeEach
    void setUp() {
        participants = new Participants("a,b,c,d");
    }

    @Test
    @DisplayName("사다리실행 시 참여자는 마지막 위치로 감")
    void executeLadder() {
        LadderExecutor ladderExecutor = new LadderExecutor(LinesTest.lines(), participants);
        ladderExecutor.executeLadder();
        //해당 형식을 테스트에서만 사용하는데 디미터 법칙을 위해 LadderExecutor에 새로 메소드를 만들어야 할까?
        assertThat(ladderExecutor.getParticipants().get(0).getPositionX()).isEqualTo(1);
        assertThat(ladderExecutor.getParticipants().get(0).getPositionY()).isEqualTo(3);

        assertThat(ladderExecutor.getParticipants().get(1).getPositionX()).isEqualTo(0);
        assertThat(ladderExecutor.getParticipants().get(1).getPositionY()).isEqualTo(3);

        assertThat(ladderExecutor.getParticipants().get(2).getPositionX()).isEqualTo(3);
        assertThat(ladderExecutor.getParticipants().get(2).getPositionY()).isEqualTo(3);

        assertThat(ladderExecutor.getParticipants().get(3).getPositionX()).isEqualTo(2);
        assertThat(ladderExecutor.getParticipants().get(3).getPositionY()).isEqualTo(3);

    }

    @Test
    @DisplayName("사다리실행클래스에서 마지막 위치를 구함")
    void getParticipantFinalPosition() {
        LadderExecutor ladderExecutor = new LadderExecutor(LinesTest.lines(), participants);
        ladderExecutor.executeLadder();

        assertThat(ladderExecutor.getParticipantFinalPosition(ladderExecutor.getParticipants().get(0)).getX()).isEqualTo(1);
        assertThat(ladderExecutor.getParticipantFinalPosition(ladderExecutor.getParticipants().get(0)).getY()).isEqualTo(3);

        assertThat(ladderExecutor.getParticipantFinalPosition(ladderExecutor.getParticipants().get(1)).getX()).isEqualTo(0);
        assertThat(ladderExecutor.getParticipantFinalPosition(ladderExecutor.getParticipants().get(1)).getY()).isEqualTo(3);

        assertThat(ladderExecutor.getParticipantFinalPosition(ladderExecutor.getParticipants().get(2)).getX()).isEqualTo(3);
        assertThat(ladderExecutor.getParticipantFinalPosition(ladderExecutor.getParticipants().get(2)).getY()).isEqualTo(3);

        assertThat(ladderExecutor.getParticipantFinalPosition(ladderExecutor.getParticipants().get(3)).getX()).isEqualTo(2);
        assertThat(ladderExecutor.getParticipantFinalPosition(ladderExecutor.getParticipants().get(3)).getY()).isEqualTo(3);
    }


}
