package ladder.step2.domain;

import ladder.step2.dto.LadderDTO;
import ladder.step2.dto.LadderResultsDTO;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private static final String INPUT_EXCEPTION_MESSAGE = "올바른 입력 형식이 아닙니다. 다시 입력해주세요.";
    private static final String PLAYER_NAMES_INPUT_FORM = "[a-zA-Z]{1,5}(,\\s?[a-zA-Z]{1,5})*";
    private static final String SPACE = " ";
    private static final String EMPTY = "";
    private static final String DELIMITER = ",";
    
    private final List<Player> players;
    
    public Players(String playerNames) {
        this.players = parsePlayers(playerNames);
    }
    
    private List<Player> parsePlayers(String playerNames) {
        checkPlayerNamesInputForm(playerNames);
        return convertToPlayers(deleteSpace(playerNames));
    }
    
    private String deleteSpace(String playerNames) {
        return playerNames.replace(SPACE, EMPTY);
    }
    
    private List<Player> convertToPlayers(String playerNames) {
        final String[] split = playerNames.split(DELIMITER);
        return IntStream.range(0, split.length)
                .mapToObj(position -> new Player(split[position], position))
                .collect(Collectors.toList());
    }
    
    private void checkPlayerNamesInputForm(String playerNames) {
        Matcher matcher = Pattern.compile(PLAYER_NAMES_INPUT_FORM).matcher(playerNames);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }
    
    public int size() {
        return players.size();
    }
    
    public List<Player> getPlayers() {
        return players;
    }
    
    public LadderGameResults parseLadderGameResults(final LadderDTO ladderDto, final LadderResultsDTO ladderResultsDto) {
        HashMap<String, String> ladderGameResults = new HashMap<>();
        
        for (Player player : players) {
            player.putLadderGameResult(ladderGameResults, ladderDto.getLineDTOS(), ladderResultsDto.getLadderResultsDTOS());
        }
        return new LadderGameResults(ladderGameResults);
    }
}
