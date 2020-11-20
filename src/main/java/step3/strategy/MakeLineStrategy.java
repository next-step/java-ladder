package step3.strategy;

import java.util.List;

@FunctionalInterface
public interface MakeLineStrategy {
    List<Boolean> create(int countOfPerson);
}
