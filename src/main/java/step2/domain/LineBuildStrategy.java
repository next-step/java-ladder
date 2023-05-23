package step2.domain;

import java.util.List;

interface LineBuildStrategy {
    List<Boolean> build(int countOfPerson);
}
