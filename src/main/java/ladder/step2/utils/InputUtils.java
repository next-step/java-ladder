package ladder.step2.utils;

import ladder.step2.domain.Player;
import ladder.step2.domain.PlayerName;
import ladder.step2.domain.Players;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputUtils {
    private static final String INPUT_EXCEPTION_MESSAGE = "올바른 입력 형식이 아닙니다. 다시 입력해주세요.";
    private static final String PLAYER_NAMES_INPUT_FORM = "[a-zA-Z]{1,5}(,\\s?[a-zA-Z]{1,5})*";
    private static final String LADDER_HEIGHT_INPUT_FORM = "[1-9][0-9]*";
    private static final String SPACE = " ";
    private static final String EMPTY = "";
    private static final String DELIMITER = ",";
    
    public static Players getPlayers(String playerNames) {
        checkAllPlayerNamesInputExceptionCase(playerNames);
        return new Players(convertToPlayers(deleteSpace(playerNames)));
    }
    
    private static String deleteSpace(String playerNames) {
        return playerNames.replace(SPACE, EMPTY);
    }
    
    private static List<Player> convertToPlayers(String playerNames) {
        return Arrays.stream(playerNames.split(DELIMITER))
                .map(PlayerName::new)
                .map(Player::new)
                .collect(Collectors.toList());
    }
    
    private static void checkAllPlayerNamesInputExceptionCase(String playerNames) {
        checkNull(playerNames);
        checkPlayerNamesInputForm(playerNames);
    }
    
    private static void checkNull(String playerNames) {
        if (playerNames == null) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }
    
    private static void checkPlayerNamesInputForm(String playerNames) {
        Matcher matcher = Pattern.compile(PLAYER_NAMES_INPUT_FORM).matcher(playerNames);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }
    
    public static int getLadderHeight(String ladderHeight) {
        checkAllLadderHeightInputExceptionCase(ladderHeight);
        return Integer.parseInt(ladderHeight);
    }
    
    private static void checkAllLadderHeightInputExceptionCase(String ladderHeight) {
        checkNull(ladderHeight);
        checkLadderHeightInputForm(ladderHeight);
    }
    
    private static void checkLadderHeightInputForm(String ladderHeight) {
        Matcher matcher = Pattern.compile(LADDER_HEIGHT_INPUT_FORM).matcher(ladderHeight);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }
}
