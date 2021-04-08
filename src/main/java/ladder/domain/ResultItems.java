package ladder.domain;

import java.util.List;

public class ResultItems {
    private final List<String> resultItems;

    public ResultItems(List<String> resultItems, int numberOfPlayers) {
        if (resultItems.size() != numberOfPlayers) {
            throw new IllegalArgumentException("실행 결과의 수는 참여자 수와 같아야 합니다");
        }
        this.resultItems = resultItems;
    }

    public String item(int index) {
        return resultItems.get(index);
    }
}
