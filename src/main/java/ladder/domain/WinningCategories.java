package ladder.domain;

import java.util.Arrays;
import java.util.List;
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

    private List<WinningCategory> convertToList(String resultList) {
        return Arrays.stream(resultList.split(","))
                .map(result -> new WinningCategory(result.trim()))
                .collect(Collectors.toUnmodifiableList());
    }

}
