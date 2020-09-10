package nextstep.domain.line.strategy;

import java.util.List;

@FunctionalInterface
public interface TransverseBarStrategy {

    List<Boolean> draw(int countOfPerson);

}
