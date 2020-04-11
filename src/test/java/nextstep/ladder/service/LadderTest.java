package nextstep.ladder.service;

import nextstep.ladder.domain.ladder.Ladder;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @Test
    void init(){
        int sizeOfPerson = 5;
        int height = 5;
        System.out.println(Ladder.init(sizeOfPerson, height));
    }

}
