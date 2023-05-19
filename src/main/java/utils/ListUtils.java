package utils;

import java.util.List;

public class ListUtils {

  public static <T> boolean hasElementAt (List<T> list, int index) {
    if (index < list.size() && list.get(index) != null) {
      return true;
    }
    return false;
  }

  public static <T> boolean hasNotElementAt (List<T> list, int index) {
    return !hasElementAt(list, index);
  }

  public static <T> int getEndIndex(List<T> list) {
    if (CollectionUtils.isNullOrEmpty(list)) {
      return 0;
    }

    return list.size() - 1;
  }
}
