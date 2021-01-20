package ladder.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomPointTest {

    @Test
    void getRandomBoolean(){
        Boolean result = RandomPoint.generateRandomPoint();
        assertThat(result).isInstanceOf(Boolean.class);
    }

    @Test
    void nextBooleanTest(){
        Boolean prevBoolean = true;
        Boolean nextBoolean = RandomPoint.nextPoint(prevBoolean);
        assertThat(nextBoolean).isFalse();
    }

}