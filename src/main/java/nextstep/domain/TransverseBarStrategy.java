package nextstep.domain;

import java.util.List;

@FunctionalInterface
public interface TransverseBarStrategy {

    List<Boolean> draw(int countOfPerson);

}
