package me.namuhuchutong.ladder.domain.engine.dto;

import me.namuhuchutong.ladder.domain.implement.LadderInformation;

import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class LadderResult {

    private static final String NEW_LINE = "\n";
    private static final String DELIMITER = ": ";
    private static final String SIX_RIGHT_ALIGNMENT = "%6s";
    private static final String OUTPUT_FORMAT = "%s\n%s%s";

    private final String formattedNames;

    private final String rows;

    private final String prize;

    private final Map<String, String> nameAndResult;

    public static LadderResult from(Map<String, String> nameAndResult, LadderInformation ladderInformation) {
        String formattedNames = ladderInformation.getNames(SIX_RIGHT_ALIGNMENT);
        String rowString = ladderInformation.getRows();
        String prize = ladderInformation.getResults(SIX_RIGHT_ALIGNMENT);
        return new LadderResult(formattedNames, rowString, prize, nameAndResult);
    }

    public LadderResult(String formattedNames, String rows, String prize, Map<String, String> nameAndResult) {
        this.formattedNames = formattedNames;
        this.rows = rows;
        this.prize = prize;
        this.nameAndResult = nameAndResult;
    }

    public String getResult(String input) {
        return Optional.ofNullable(nameAndResult.get(input))
                       .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 키 값입니다. - " + input));
    }

    public String getAllResults() {
        return nameAndResult.keySet()
                            .stream()
                            .map(key -> key + DELIMITER + nameAndResult.get(key))
                            .collect(joining(NEW_LINE));
    }

    public String showLadder() {
        return String.format(OUTPUT_FORMAT, formattedNames, rows, prize);
    }
}
