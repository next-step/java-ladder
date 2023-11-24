package nextstep.studytest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class RandomTest {

    @DisplayName("랜덤한 boolean 값을 반환하는 테스트")
    @Test
    void test() {
        Random random = new Random();

        for(int i=0; i<5; i++) {
            System.out.println(random.nextBoolean());
        }
    }
}
