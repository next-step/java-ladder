package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    private final Participants defaultParticipants = Participants.of(List.of("pobi", "honux", "crong", "jk"));
    private final Ladder defaultLadder = new Ladder(LadderHeight.of(3), defaultParticipants, () -> true);

    @DisplayName("높이만큼 HorizonLine 을 가진다.")
    @Test
    public void hasHorizonLineTest() {
        assertThat(defaultLadder.getHeight()).isEqualTo(3);
    }

    @DisplayName("최소 높이 보다 작은 높이가 입력되면 IllegalArgumentException 이 발생한다.")
    @Test
    public void createLessThanMinHeight() {
        assertThatThrownBy(() -> {
            new Ladder(LadderHeight.of(1), defaultParticipants);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("최소 참여 사용자 수 보다 작은 사용자 수가 입력되면 IllegalArgumentException 이 발생한다.")
    @Test
    public void createLessThanMinStratPositon() {
        Participants participants = Participants.of(List.of("pobi"));

        assertThatThrownBy(() -> {
            new Ladder(LadderHeight.of(3), participants);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("가로라인의 짧은 라인(ShortLine)는 (입렫된 사용자의 수 - 1) 개까지 만든다.")
    @Test
    public void createShortLineInHorizonLine() {
        assertThat(defaultLadder.getShortLineCountInHorizonLine(0)).isEqualTo(3);
        assertThat(defaultLadder.getShortLineCountInHorizonLine(1)).isEqualTo(3);
        assertThat(defaultLadder.getShortLineCountInHorizonLine(2)).isEqualTo(3);
    }

    @DisplayName("입력되는 Horizon Line 높이와 사다리 시작점에서 오른쪽에 ShortLine 의 유무를 알 수 있다.")
    @Test
    public void isEnabledShortLineOfRightTest() {
        assertThat(defaultLadder.isEnabledShortLineOfRight(0, Position.of(0))).isTrue();
        assertThat(defaultLadder.isEnabledShortLineOfRight(1, Position.of(1))).isFalse();
    }

    @DisplayName("게임을 진행하고 최종 사다리 위치 index 를 리턴한다.")
    @Test
    public void playTest() {
        assertThat(defaultLadder.play(Position.of(3))).isEqualTo(Position.of(2));
    }

    @DisplayName("모든 startPosition에 대해서 게임을 진행하고 사다리 위치 index 들을 리턴한다.")
    @Test
    public void playTestAll() {
        List<Position> result = defaultLadder.playAll();

        assertThat(result).containsSequence(Position.of(1), Position.of(0), Position.of(3), Position.of(2));
    }
}
