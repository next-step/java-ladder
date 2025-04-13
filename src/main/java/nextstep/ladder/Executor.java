package nextstep.ladder;

import java.util.Map;

public interface Executor {
  String execute(String name);
  Map<String, String> executeAll();
}
