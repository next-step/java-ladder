package ladder.domain.model.Param;

import ladder.domain.model.PlayerName;
import ladder.domain.model.PlayerNames;
import ladder.domain.model.WinResult;
import ladder.domain.model.WinResults;
import ladder.exception.PlayerCountArgumentException;
import ladder.exception.WinResultsArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
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

    public WinResults convertParamToModel() {
        List<String> winResults = Arrays.stream(winResultsString.replaceAll(TRIM, "")
                .split(DELIMITER)).collect(Collectors.toList());

        List<String> finalWinResults = winResults;
        Supplier<WinResults> supplier = () -> new WinResults(finalWinResults.stream()
                .map(result -> new WinResult(result))
                .collect(Collectors.toList()));

        return supplier.get();

    }
}
