package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningCategories {

    private final List<WinningCategory> winningCategoryList;

    public WinningCategories(String resultNames) {
        this.winningCategoryList = convertToList(resultNames);
    }

    public List<String> getResultNames() {
        return winningCategoryList.stream()
                .map(WinningCategory::getResultName)
                .collect(Collectors.toList());
    }

    public WinningCategory find(int index) {
        return this.winningCategoryList.get(index);
    }

    private List<WinningCategory> convertToList(String resultList) {
        return Arrays.stream(resultList.split(","))
                .map(result -> new WinningCategory(result.trim()))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WinningCategories)) {
            return false;
        }

        WinningCategories that = (WinningCategories) o;

        return Objects.equals(winningCategoryList, that.winningCategoryList);
    }

    @Override
    public int hashCode() {
        return winningCategoryList != null ? winningCategoryList.hashCode() : 0;
    }

    @Override
    public String toString() {
        return winningCategoryList.stream()
                .map(WinningCategory::toString)
                .collect(Collectors.joining(""));
    }
}
