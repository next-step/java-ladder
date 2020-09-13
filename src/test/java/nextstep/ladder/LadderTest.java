package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("ladder 생성 테스트")
    public void test(){
        String[] strArr = new String[]{"test1", "test2", "test3","test4"};
        int height = 5;

        Ladder ladder = new Ladder(strArr, height);

        System.out.println(ladder.getLadderStr());
    }
}