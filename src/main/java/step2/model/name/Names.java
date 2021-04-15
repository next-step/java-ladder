package step2.model.name;

import step2.error.InvalidNameException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Names {
  private static final String SPLIT_DELIMITER = ",";
  private static final int MINIMUM_NAMES_LENGTH = 2;

  private final List<Name> names;

  private Names(List<Name> names) {
    this.names = names;
  }

  public static Names initNames(String names) {
    String[] splittedNames = names.split(SPLIT_DELIMITER);
    checkNamesLength(splittedNames.length);

    List<Name> madeNames = Arrays.stream(splittedNames)
      .map(name -> new Name(name.trim()))
      .collect(Collectors.toList());
    return new Names(madeNames);
  }

  private static void checkNamesLength(int length) {
    if (length < MINIMUM_NAMES_LENGTH) {
      throw new InvalidNameException("");
    }
  }

  public Stream<Name> stream() {
    return names.stream();
  }

  public int size() {
    return names.size();
  }

  public boolean isNameContains(Name name) {
    return names.contains(name);
  }

}
