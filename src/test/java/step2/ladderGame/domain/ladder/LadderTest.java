package step2.ladderGame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.ladderGame.domain.ladder.pointGenerationStrategy.horizontalLineRandomGenerationStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("NonAsciiCharacters")
class LadderTest {

    @DisplayName("생성")
    @Test
    void create() {
        Ladder ladder = new Ladder(5, new horizontalLineRandomGenerationStrategy(), 5);
        assertThat(ladder).isInstanceOf(Ladder.class);
    }

    @DisplayName("참여자수가 2명 미만일 경우 에러")
    @Test
    void create_참여자수가_2명_미만일_경우_에러() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(1, new horizontalLineRandomGenerationStrategy(), 5);
        }).withMessageMatching("참가자는 두명 이상이어야 합니다.");
    }

    @DisplayName("사다리 높이가 1 미만일 경우 에러")
    @Test
    void create_사다리_높이가_1미만일_경우_에러() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(5, new horizontalLineRandomGenerationStrategy(), 0);
        }).withMessageMatching("사다리 높이는 1 이상이어야 합니다.");
    }

}
