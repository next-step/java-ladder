package ladder.model;

import ladder.model.utils.StringToListConverter;

import java.util.List;

public class GameResult {
    private final List<String> resultList;

    public GameResult(String resultList, int numberOfPlayer){
        this.resultList = StringToListConverter.toList(resultList);
        checkValidGameResult(numberOfPlayer);
    }

    private void checkValidGameResult(int numberOfPlayer){
        if(numberOfPlayer != resultList.size()){
            throw new IllegalArgumentException("게임 결과 수와 사람 수는 같아야 한다.");
        }
    }

}
