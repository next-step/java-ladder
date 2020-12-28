package nextstep.ladder.floor;

import nextstep.ladder.domain.floor.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FloorFactoryTest {

    @Test
    @DisplayName("생성된 DefaultFloorFactory의 가로 연결이 요구사항에 맞는지 검사한다")
    public void floorLinkTest_DefaultFloorFactory() {
        Floor floor = new DefaultFloorFactory().generate(100);
        floorLinkTest(floor);
    }

    @Test
    @DisplayName("생성된 RandomFloorFactory의 가로 연결이 요구사항에 맞는지 검사한다")
    public void floorLinkTest_RandomFloorFactory() {
        Floor floor = new RandomFloorFactory().generate(100);
        floorLinkTest(floor);
    }

    private void floorLinkTest(Floor floor) {
        Position position = new Position(1, floor.getSizeOfPositions());
        while(!position.isMostRight()) {
            assertThat(floor.getLeftLinkOf(position) == Link.LINKED
                    && floor.getRightLinkOf(position) == Link.LINKED).isFalse();
            position.moveRight();
        }
    }
}
