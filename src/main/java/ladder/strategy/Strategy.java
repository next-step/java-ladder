package ladder.strategy;

import java.util.function.Supplier;

/**
 * Note: Strategy 가 Supplier 가 아닌 다른 인터페이스가 될 수도 있으므로,
 * 일부러 Strategy abstract 클래스를 만들었다.
 * 다른 인터페이스로 정의하고 싶다면, Strategy 클래스를 인터페이스로 바꾸면 된다.
 */
public abstract class Strategy implements Supplier<Boolean> {
    @Override
    public abstract Boolean get();
}
