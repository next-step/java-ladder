package nextstep.ladder.entity.ladder;

import org.junit.jupiter.api.Test;

class LadderTest {

    private LinkGenerator linkGenerator = RandomLinkGenerator.getInstance();

    @Test
    void test_createLadder() {
        // Given
        FloorGenerator floorGenerator = new FloorGenerator(linkGenerator, new LadderLine(4));
        Ladder ladder = Ladder.create(new LadderHeight(5), floorGenerator);

        System.out.println(ladder.toString());
    }
}