package nextstep.ladder.view;

import nextstep.ladder.dto.LineDto;
import nextstep.ladder.dto.ParticipationNameDto;
import nextstep.ladder.dto.PointDto;

import java.util.List;

public class ResultView {

    private static final String DELIMETER = "|";
    private static final String EMPTY = " ";

    private ResultView() {}

    public static void resultPrint(final List<ParticipationNameDto> participationNames, final List<LineDto> linesDto) {

        System.out.println("실행 결과");
        resultNamePrint(participationNames);
        resultLadderPrint(linesDto);
    }

    private static void resultNamePrint(final List<ParticipationNameDto> participationNames) {

        int index = 0;
        StringBuilder result = new StringBuilder(DELIMETER);
        for (ParticipationNameDto participationName : participationNames) {
            final String name = participationName.getNames();
            if (index == participationNames.size()) {
                result.append(name);
                continue;
            }
            result.append(name).append(EMPTY);
            index++;
        }
        System.out.println(result);
    }

    private static void resultLadderPrint(final List<LineDto> linesDto) {

        for (LineDto lineDto : linesDto) {
            final List<PointDto> pointsDto = lineDto.getPointsDto();
            System.out.println(resultLadder(pointsDto));
        }
    }

    private static String resultLadder(final List<PointDto> pointsDto) {

        StringBuilder result = new StringBuilder(DELIMETER);
        for (PointDto pointDto : pointsDto) {
            result.append(check(pointDto.isRight()));
            result.append(DELIMETER);
        }
        return result.toString();
    }

    private static String check(final boolean right) {

        if (right) {
            return "-----";
        }
        return "     ";
    }
}
