package nextstep.ladder;

import nextstep.ladder.model.Ladder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @Test
    void 사다리_높이와_인원에_따른_라인_수_확인() {
        int height = 5;
        int countOfPerson = 3;
        Ladder ladder = new Ladder(height, countOfPerson);

        assertThat(ladder.getLines().size()).isEqualTo(height);
    }

    @Test
    void 사다리_높이가_0일_때_IllegalArgumentException이_발생() {
        assertThatThrownBy(() -> new Ladder(0, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 0보다 커야 합니다.");
    }

    @Test
    void 사다리_라인이_정상적으로_생성되는지_확인() {
        Ladder ladder = new Ladder(2, 2);

        assertThat(ladder.getLines()).isNotEmpty();
    }

    @Test
    void 사다리_라인_가져오기() {
        Ladder ladder = new Ladder(3, 3);

        assertThat(ladder.getLines().size()).isEqualTo(3);
    }

    @Test
    void 사다리_높이_가져오기() {
        Ladder ladder = new Ladder(3, 3);

        assertThat(ladder.getHeight()).isEqualTo(3);
    }

    @Test
    void 사다리_참여자수_검증() {
        assertThatThrownBy(() -> new Ladder(3, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 인원은 2명 이상이어야 합니다.");
    }
}
