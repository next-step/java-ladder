package nextstep.ladder.service;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderServiceTest {

    private ArrayList<Boolean> points = new ArrayList<>();
    private Line line = new Line(points);

    @BeforeEach
    void setUp() {
    }
    @Test
    @DisplayName("높이 만큼 사다리 높이가 생성된다.")
    void line_Vertical_Test() {
        Ladder ladder = Ladder.generate(4, 3);
        System.out.println("ladder.toString() = " + ladder.toString());

        assertThat(ladder.getHeight()).isEqualTo(3);
    }

    @Test
    @DisplayName("사다리는 라인이 겹치지 않아야한다.")
    void line_Generate_Test() {
    }
}
