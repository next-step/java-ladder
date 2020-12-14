package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Ladder;

public class LadderTest {
    
    @Test
    void ladderTest(){
        String[] test = {"test1","test2","test3","test4"};
        int size = 4;

        Ladder ladder = new Ladder();
        ladder.setLadder(test.length, size);

        assertThat(ladder.getLadder().size()).isEqualTo(4);
        assertThat(ladder.getLadder().get(0).getArray().length).isEqualTo(7);
        assertThat(ladder.getLadder().get(0).getArray()[0]).isEqualTo(2);
    }

    @Test
    void validateRowTest(){
        Integer[] test = {2,1,2,1,2};
        int size = 4;

        Ladder ladder = new Ladder();
        Integer[] result = ladder.validateRow(test, 3);
        
        assertThat(result[3]).isEqualTo(0);
    }
}