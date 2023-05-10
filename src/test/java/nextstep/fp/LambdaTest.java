package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaTest {
    private List<Integer> numbers;

    @BeforeEach
    public void setup() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void printAllOld() throws Exception {
        Lambda.printAllOld(numbers);
    }

    @Test
    public void printAllLambda() throws Exception {
        Lambda.printAllLambda(numbers);
    }

    @Test
    public void runThread() throws Exception {
        Lambda.runThread();
    }

    @Test
    public void sumAll() throws Exception {
        Conditional all = new Conditional() {
            @Override
            public boolean test(Integer number) {
                return true;
            }
        };

        int sum = Lambda.sumAll(numbers,all);
        assertThat(sum).isEqualTo(21);
    }

    @Test
    public void sumAll_람다활용_인라인() {
        int sum = Lambda.sumAll(numbers, (number) -> true );
        assertThat(sum).isEqualTo(21);
    }

    @Test
    public void sumAll_람다활용_변수() {
        Conditional all = (number) -> true;
        int sum = Lambda.sumAll(numbers, all);
        assertThat(sum).isEqualTo(21);
    }

    @Test
    public void sumAll_람다활용_메서드() {
        int sum = Lambda.sumAll(numbers, isTrue());
        assertThat(sum).isEqualTo(21);
    }

    private Conditional isTrue() {
        return (number) -> true;
    }

    @Test
    public void sumAllEven() throws Exception {
        Conditional allEven = new Conditional() {
            @Override
            public boolean test(Integer number) {
                return number % 2 == 0;
            }
        };

        int sum = Lambda.sumAllEven(numbers, allEven);
        assertThat(sum).isEqualTo(12);
    }

    @Test
    public void sumAllEven_람다활용_인라인() {
        int sum = Lambda.sumAllEven(numbers, (number) -> number % 2 == 0);
        assertThat(sum).isEqualTo(12);
    }

    @Test
    public void sumAllEven_람다활용_변수() {
        Conditional allEven = (number) -> number % 2 == 0;
        int sum = Lambda.sumAllEven(numbers, allEven);
        assertThat(sum).isEqualTo(12);
    }

    @Test
    public void sumAllEven_람다활용_메서드() {
        int sum = Lambda.sumAllEven(numbers, isEven());
        assertThat(sum).isEqualTo(12);
    }

    private Conditional isEven() {
        return (number) -> number % 2 == 0;
    }

    @Test
    public void sumAllOverThree() throws Exception {
        Conditional overThree = new Conditional() {
            @Override
            public boolean test(Integer number) {
                return number > 3;
            }
        };

        int sum = Lambda.sumAllOverThree(numbers, overThree);
        assertThat(sum).isEqualTo(15);
    }

    @Test
    public void sumAllOverThree_람다활용_인라인() {
        int sum = Lambda.sumAllOverThree(numbers, (number) -> number > 3);
        assertThat(sum).isEqualTo(15);
    }

    @Test
    public void sumAllOverThree_람다활용_변수() {
        Conditional overThree = (number) -> number > 3;
        int sum = Lambda.sumAllOverThree(numbers, overThree);
        assertThat(sum).isEqualTo(15);
    }

    @Test
    public void sumAllOverThree_람다활용_메서드() {
        int sum = Lambda.sumAllOverThree(numbers, isOverThree());
        assertThat(sum).isEqualTo(15);
    }

    private Conditional isOverThree() {
        return (number) -> number > 3;
    }
}
