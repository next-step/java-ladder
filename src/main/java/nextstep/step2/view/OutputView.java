package nextstep.step2.view;

import nextstep.step2.domain.Ladder;
import nextstep.step2.domain.LadderGame;
import nextstep.step2.domain.Line;
import nextstep.step2.vo.Bridge;
import nextstep.step2.vo.Name;
import nextstep.step2.vo.Names;

import java.util.stream.Collectors;

public class OutputView {

    private static final int NUMBER_OF_SPACE_BETWEEN_NAMES = 7;
    private static final String SPACE = " ";
    private static final String LADDER_SPACE = "     ";
    private static final String LADDER = "|";
    private static final String BRIDGE = "-----";

    public void renderLadder(LadderGame game) {
        System.out.println("실행 결과");
        System.out.println(namesToPrintString(game.getNames()));
        System.out.println(ladderToPrintString(game.getLadder()));
    }

    public String namesToPrintString(Names names) {
        return names.getNames().stream()
                .map(this::nameToPintString)
                .collect(Collectors.joining());
    }

    private String nameToPintString(Name name) {
        StringBuilder builder = new StringBuilder();
        builder.append(name.getValue());
        for (int i = name.length(); i < NUMBER_OF_SPACE_BETWEEN_NAMES; i++) {
            builder.append(SPACE);
        }
        return builder.toString();
    }

    public String ladderToPrintString(Ladder ladder) {
        return ladder.getLineList().stream()
                .map(this::lineToPrintString)
                .collect(Collectors.joining("\n"));
    }

    private String lineToPrintString(Line line) {
        StringBuilder builder = new StringBuilder();
        builder.append(LADDER_SPACE);
        builder.append(LADDER);
        builder.append(
                line.getBridges().stream()
                        .map(this::bridgeToPrintString)
                        .collect(Collectors.joining(LADDER))
        );
        builder.append(LADDER);
        return builder.toString();
    }

    private String bridgeToPrintString(Bridge bridge) {
        if (bridge.getValue()) {
            return BRIDGE;
        }
        return LADDER_SPACE;
    }
}
