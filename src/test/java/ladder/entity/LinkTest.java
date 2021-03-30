package ladder.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LinkTest {

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7,8,9,10,0x7fffffff})
    void canGenerateStallLink(int index){
        Point point = new Point(index);
        MoveStill moveStill = new MoveStill();
        Link link = new Link(point, moveStill);
        Assertions.assertThat(link.to()).isEqualTo(point.move(moveStill));
    }
}
