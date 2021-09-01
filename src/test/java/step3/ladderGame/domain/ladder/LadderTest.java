package step3.ladderGame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("NonAsciiCharacters")
class LadderTest {

    @DisplayName("생성")
    @Test
    void create() {
        assertThat(new Ladder(5, 5)).isInstanceOf(Ladder.class);
    }

    @DisplayName("참가자가 두명 미만일 경우 에러 발생")
    @Test
    void validate_참가자가_두명_미만일_경우_에러() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(1, 5);
        }).withMessageMatching("참가자는 두명 이상이어야 합니다.");
    }

    @DisplayName("사다리 높이가 1 미만일 경우 에러 발생")
    @Test
    void validate_사다리_높이가_1미만일_경우_에러() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(5, 0);
        }).withMessageMatching("사다리 높이는 1 이상이어야 합니다.");
    }

    @DisplayName("이동")
    @Test
    void move() {
        Ladder ladder = new Ladder(5, 5);
        assertThat(ladder.move(1)).isInstanceOf(Integer.class);
    }

}
