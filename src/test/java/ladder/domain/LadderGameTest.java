package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGameTest {

    @Test
    @DisplayName("사다리 게임 생성 - 참가자정보 미입력")
    void participantsIsNull() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGame(null, 5))
                .withMessageMatching("참가자 정보를 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("사다리 게임 생성 - 사다리 높이 검증")
    void ladderHeight(int ladderHeight) {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGame(new Participants("pobi,honux,crong,jk"), ladderHeight))
                .withMessageMatching("사다리의 높이는 최소 1 이상이어야 합니다.");
    }

    @Test
    @DisplayName("참가자 수 검증")
    void participantsCount() {
        // given
        Participants participants = new Participants("pobi,honux,crong,jk");

        // when
        LadderGame ladderGame = new LadderGame(participants, 5);

        // then
        assertThat(4).isEqualTo(ladderGame.getParticipants().getCount());
    }

    @Test
    @DisplayName("참가자 명 검증")
    void participantName() {
        // given
        String participantNames = "pobi,honux,crong,jk";
        Participants participants = new Participants(participantNames);

        // when
        LadderGame ladderGame = new LadderGame(participants, 5);

        // then
        for (Participant participant : ladderGame.getParticipants().getParticipants()) {
            assertThat(Arrays.asList(participantNames.split(",")).contains(participant.getName())).isTrue();
        }
    }

    @Test
    @DisplayName("사다리 생성 검증")
    void ladder() {
        // given
        Participants participants = new Participants("pobi,honux,crong,jk");

        // when
        LadderGame ladderGame = new LadderGame(participants, 5);
        List<Line> lineList = ladderGame.getLines();

        // then
        assertAll(
                () -> assertThat(5).isEqualTo(lineList.size()),
                () -> lineList.forEach(line -> assertThat(4).isEqualTo(line.getPoints().size()))
        );
    }

    @Test
    @DisplayName("그려진 사다리는 수정할 수 없음")
    void ladderIsUnmodifiable() {
        // given
        Participants participants = new Participants("pobi,honux,crong,jk");

        // when
        LadderGame ladderGame = new LadderGame(participants, 5);
        List<Line> lineList = ladderGame.getLines();

        // then
        assertThrows(UnsupportedOperationException.class, () -> lineList.add(new Line(5)));
    }
}