package refactoring.domain;

import java.util.Map;

public interface Match {

    void put(int position, String results);
    String getResult(int position);
    Map<Integer, String> getAll();
}
