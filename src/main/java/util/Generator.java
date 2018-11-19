package util;

import java.util.List;

@FunctionalInterface
public interface Generator {
    List<Boolean> generate(int countOfPerson);
}
