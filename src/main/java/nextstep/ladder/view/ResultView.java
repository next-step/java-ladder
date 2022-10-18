package nextstep.ladder.view;

import nextstep.ladder.dto.LadderResultDto;
import nextstep.ladder.dto.LineDto;
import nextstep.ladder.dto.ParticipationNameDto;
import nextstep.ladder.dto.PointDto;

import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String DELIMITER = "|";
    private static final String EMPTY = " ";
    private static final String THREE_EMPTY = "   ";

    private ResultView() {}

    private static void resultTitlePrint() {

        System.out.println("실행 결과");
    }

    public static void resultPrint(final List<ParticipationNameDto> participationNames, final List<LineDto> linesDto, final List<String> resultNames) {

        resultTitlePrint();
        resultNamePrint(participationNames);
        resultLadderPrint(linesDto);
        resultWinningResultPrint(resultNames);
    }

    private static void resultWinningResultPrint(final List<String> resultNames) {

        int index = 0;
        final StringBuilder result = new StringBuilder();
        for (String resultName : resultNames) {
            if (index == resultNames.size()) {
                result.append(resultName);
                continue;
            }
            result.append(resultName).append(THREE_EMPTY);
            index++;
        }
        System.out.println(result);
    }

    private static void resultNamePrint(final List<ParticipationNameDto> participationNames) {

        int index = 0;
        final StringBuilder result = new StringBuilder();
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

        final StringBuilder result = new StringBuilder(DELIMITER);
        for (PointDto pointDto : pointsDto) {
            result.append(check(pointDto.isRight()));
            result.append(DELIMITER);
        }
        return result.toString();
    }

    private static String check(final boolean right) {

        if (right) {
            return "-----";
        }
        return "     ";
    }

    public static void resultName(final String name, final LadderResultDto ladderResultDto) {

        resultTitlePrint();

        final Map<String, String> ladderResultDtoMap = ladderResultDto.getLadderResultDto();
        if ("all".equals(name)) {
            printOfAll(ladderResultDtoMap);
            return ;
        }
        if (ladderResultDtoMap.containsKey(name)) {
            System.out.println(ladderResultDtoMap.get(name));
            return ;
        }

        throw new IllegalArgumentException("해당 사용자는 존재하지 않습니다.");
    }

    private static void printOfAll(final Map<String, String> ladderResultDtoMap) {

        for (String key : ladderResultDtoMap.keySet()) {
            System.out.printf(key + ":" + ladderResultDtoMap.get(key));
            System.out.println();
        }
    }
}
