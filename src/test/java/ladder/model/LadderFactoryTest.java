package ladder.model;

import ladder.model.stub.LadderMovingStub;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class LadderFactoryTest {

    @Test
    void 높이가_3이고_너비가_2인_사다리_만들기(){
        int width = 3;
        int height = 2;

        Ladder ladder = LadderFactory.create(3, 2, new LadderMovingStub());

        assertThat(ladder.getWidth()).isEqualTo(width);
        assertThat(ladder.getHeight()).isEqualTo(height);

    }

}
