package utils;

import java.util.List;

public class ListUtils {

  public static <T> boolean hasElementAt (List<T> list, int index) {
    if (index < list.size() && list.get(index) != null) {
      return true;
    }
    return false;
  }
}
