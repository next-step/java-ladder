package nextstep.ladder;

import java.util.List;

public interface Mapping {
  int indexOf(String name);
  String resultOfIndex(int index);
  List<String> names();
}
