package ladder2.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultItems {
    private static final String SPLIT_DELIMITER = ",";
    private List<ResultItem> resultItems;

    private ResultItems(List<String> items) {
        this.resultItems = items.stream().map(item -> ResultItem.from(item)).collect(Collectors.toList());
    }

    public static ResultItems fromComma(String items) {
        return new ResultItems(Arrays.asList(items.replaceAll(" ", "").split(SPLIT_DELIMITER)));
    }

    public ResultItem match(int index) {
        return resultItems.get(index);
    }

    public List<ResultItem> getResultItems() {
        return Collections.unmodifiableList(resultItems);
    }

    public int size() {
        return resultItems.size();
    }
}
