package ladder.domain;

import common.utils.StringUtils;

import java.util.Arrays;
import java.util.List;

public class GameResults {

    private static final String NAME_DELIMITER = ",";

    private final List<String> gameResults;

    public GameResults(String gameResultNames, int participantsCount) {
        this(generateGameResults(gameResultNames, participantsCount));
    }

    public GameResults(List<String> gameResults) {
        this.gameResults = gameResults;
    }

    private static List<String> generateGameResults(String gameResultNames, int participantsCount) {
        validateGameResultNames(gameResultNames);
        return generateGameResults(Arrays.asList(gameResultNames.split(NAME_DELIMITER)), participantsCount);
    }

    private static void validateGameResultNames(String gameResultNames) {
        if (StringUtils.isBlank(gameResultNames)) {
            throw new IllegalArgumentException("게임 결과를 입력해 주세요.");
        }
    }

    private static List<String> generateGameResults(List<String> gameResults, int participantsCount) {
        validateGameResultNames(gameResults, participantsCount);
        return gameResults;
    }

    private static void validateGameResultNames(List<String> gameResults, int participantsCount) {
        if (gameResults.size() != participantsCount) {
            throw new IllegalArgumentException("게임 결과 수는 참가자 수와 같아야 합니다.");
        }
        if (isBlankPresent(gameResults)) {
            throw new IllegalArgumentException("유효하지 않은 결과값이 존재합니다. 입력값을 확인해주세요.");
        }
    }

    private static boolean isBlankPresent(List<String> gameResults) {
        return gameResults.stream().anyMatch(StringUtils::isBlank);
    }

    public List<String> getGameResults() {
        return gameResults;
    }

    public String getGameResult(int ladderExitNumber) {
        return gameResults.get(ladderExitNumber);
    }
}
