package nextstep.ladder.floor;

import nextstep.ladder.domain.floor.DefaultFloorFactory;
import nextstep.ladder.domain.floor.Floor;
import nextstep.ladder.domain.floor.Link;
import nextstep.ladder.domain.floor.RandomFloorFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FloorFactoryTest {

    @Test
    @DisplayName("생성된 DefaultFloorFactory의 가로 연결이 요구사항에 맞는지 검사한다")
    public void floorLinkTest_DefaultFloorFactory() {
        Floor floor = new DefaultFloorFactory().generate(10);
        floorLinkTest(floor);
    }

    @Test
    @DisplayName("생성된 RandomFloorFactory의 가로 연결이 요구사항에 맞는지 검사한다")
    public void floorLinkTest_RandomFloorFactory() {
        Floor floor = new RandomFloorFactory().generate(10);
        floorLinkTest(floor);
    }

    private void floorLinkTest(Floor floor) {
        for (int i = 1; i < floor.getSizeOfLinks(); i++) {
            // 연속으로 연결이 두번 있으면 안된다
            assertThat(floor.getLink(i - 1) == Link.LINKED && floor.getLink(i) == Link.LINKED).isFalse();
        }
    }
}
