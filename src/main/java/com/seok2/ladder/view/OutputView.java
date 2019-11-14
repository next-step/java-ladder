package com.seok2.ladder.view;

import com.seok2.ladder.game.dto.ResultDTO;
import com.seok2.ladder.product.dto.PrizeDTO;
import com.seok2.ladder.product.dto.PrizesDTO;
import com.seok2.ladder.structure.dto.LadderDTO;
import com.seok2.ladder.user.dto.ParticipantDTO;
import com.seok2.ladder.user.dto.ParticipantsDTO;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class OutputView {

    private static final String BLANK = "  ";
    private static final String VERTICAL_LINE = "|      ";
    private static final String HORIZONTAL_LINE = "|------";
    private static final String RESULT_ONE = "결과를 보고 싶은 사람은?";
    private static final String RESULT = "실행 결과";
    private static final String NOT_EXIST = "{0} 는 참가하지 않은 사람입니다.";
    private static final String DELIMITER = ": ";
    private static final Scanner scanner = new Scanner(System.in);

    private OutputView() {
    }

    public static void printParticipant(ParticipantsDTO participantsDTO) {
        List<ParticipantDTO> participants = participantsDTO.getParticipants();
        for (ParticipantDTO participant : participants) {
            System.out.print(String.format("%-5s", participant.getName()) + BLANK);
        }
    }

    public static void printLadder(LadderDTO ladderDTO) {
        ladderDTO.getLayers().stream()
                .limit(ladderDTO.getLayers().size() - 1)
                .flatMap(x -> {
                    System.out.println();
                    return x.getLayer().stream();
                })
                .forEach(y -> System.out.print(y.getRung() ? HORIZONTAL_LINE : VERTICAL_LINE));
        System.out.println();
    }

    public static void printPrizes(PrizesDTO prizesDTO) {
        List<PrizeDTO> prizes = prizesDTO.getPrizesDTO();
        for (PrizeDTO prizeDTO : prizes) {
            System.out.print(String.format("%-5s", prizeDTO.getName()) + BLANK);
        }
        System.out.println();
    }

    public static void printResult(ResultDTO resultDTO) {
        Map<String, String> result = resultDTO.getResult();
        while (true) {
            System.out.println(RESULT_ONE);
            String input = scanner.nextLine();
            System.out.println(RESULT);
            if (input.equals("all")) {
                break;
            }
            Optional<String> temp = Optional.ofNullable(result.get(input));
            if (!temp.isPresent()) {
                System.out.println(MessageFormat.format(NOT_EXIST, input));
                continue;
            }
            System.out.println(input + DELIMITER + temp.get());

        }
        result.entrySet()
                .forEach(e -> System.out.println(e.getKey() + DELIMITER + e.getValue()));
    }
}
