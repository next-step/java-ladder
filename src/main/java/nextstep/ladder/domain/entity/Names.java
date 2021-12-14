package nextstep.ladder.domain.entity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Names {

  private static final String COMMA = ",";

  private final List<Name> nameList;

  public Names(String nameList) {
    this(getSplitNameByDelimiter(nameList));
  }

  public Names(List<Name> nameList) {
    this.nameList = nameList;
  }

  private static List<Name> getSplitNameByDelimiter(String name) {
    return Arrays.stream(name.split(COMMA))
                 .map(String::trim)
                 .map(Name::new)
                 .collect(toList());
  }

  public List<Name> getNameList() {
    return this.nameList;
  }

  public Name getName(int index) {
    return nameList.get(index);
  }

  public int size() {
    return nameList.size();
  }

  public Stream<Name> stream() {
    return nameList.stream();
  }

}
