package nextstep.step4.responsibility.domain;

import java.util.Map;

public interface GameResultProvider {
    String getResult(String name);

    Map<String, String> getAllResult();
}
