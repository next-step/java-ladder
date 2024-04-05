package ladder.model;

import ladder.model.utils.StringToListConverter;

import java.util.List;

public class GameResultList {
    private static final int MAX_LENGTH = 5;
    private final List<String> resultList;

    public GameResultList(String resultList, int numberOfPlayer) {
        this.resultList = StringToListConverter.toList(resultList);
        checkLength();
        checkValidGameResult(numberOfPlayer);
    }

    private void checkValidGameResult(int numberOfPlayer) {
        if (numberOfPlayer != resultList.size()) {
            throw new IllegalArgumentException("게임 결과 수와 사람 수는 같아야 한다.");
        }
    }

    private void checkLength() {
        resultList.stream()
                .filter(result -> result.length() > MAX_LENGTH)
                .findFirst()
                .ifPresent(result -> {
                    throw new IllegalArgumentException("결과는 5자 이하.");
                });
    }

    public List<String> getResultList() {
        return resultList;
    }

}
