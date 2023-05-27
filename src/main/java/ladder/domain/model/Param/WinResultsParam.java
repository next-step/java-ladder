package ladder.domain.model.Param;

import ladder.NameUtils;
import ladder.domain.model.WinResult;
import ladder.domain.model.WinResults;
import ladder.exception.WinResultsArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinResultsParam {
    private static final String DELIMITER = ",";
    private static final String TRIM = " ";
    private String winResultsString;

    public WinResultsParam(String winResultsString) {
        if (winResultsString.isEmpty()) {
            throw new WinResultsArgumentException("비어 있는 값을 입력하였습니다.");
        }

        this.winResultsString = winResultsString;
    }

    public WinResults convertParamToModel(int playerCount) {
        List<String> winResults = Arrays.stream(winResultsString.replaceAll(TRIM, "")
                .split(DELIMITER)).collect(Collectors.toList());

        if (playerCount != winResults.size()) {
            throw new WinResultsArgumentException("플레이어 수와 결과 값이 일치하지 않습니다.");
        }

        winResults = NameUtils.fillOrRightAlign(winResults);
        List<String> finalWinResults = winResults;

        return  new WinResults(finalWinResults.stream()
                .map(result -> new WinResult(result))
                .collect(Collectors.toList()));

    }
}
