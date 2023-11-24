package nextstep.step4.responsibility.domain;

import java.util.List;

public interface UserInputProvider {
    String get(int index);

    int size();

    List<String> getList();
}
