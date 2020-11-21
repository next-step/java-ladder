package ladder.view.printable;

import ladder.dto.PersonDto;
import ladder.dto.PersonsDto;
import ladder.dto.ResultDto;
import ladder.dto.ResultsDto;
import ladder.dto.response.LadderDto;
import ladder.dto.response.LineDto;
import ladder.dto.response.LinesDto;
import ladder.dto.response.PointDto;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ladder.asset.LadderConst.STANDARD_LENGTH;

public class LadderPrintable extends Printable {
    private final LadderDto dto;

    public LadderPrintable(final LadderDto ladderDto) {
        dto = ladderDto;
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator());
        sb.append("사다리 결과");
        sb.append(System.lineSeparator());
        sb.append(System.lineSeparator());
        sb.append(toString(dto.getPersons()));
        sb.append(toString(dto.getLines()));
        sb.append(System.lineSeparator());
        sb.append(toString(dto.getResults()));
        println(sb);
    }

    private String toString(PersonsDto dto) {
        return dto.getPersons().stream()
                .map(person -> toString(person))
                .reduce("", String::concat);
    }

    private String toString(PersonDto dto) {
        String name = dto.getName();
        return addWhiteSpaces(name);
    }

    private String toString(LinesDto dto) {
        return dto.getLines().stream()
                .map(line -> System.lineSeparator() + toString(line))
                .reduce("", String::concat);
    }

    private String toString(LineDto dto) {
        return dto.getPoints().stream()
                .map(point -> toString(point))
                .reduce("", String::concat);
    }

    private String toString(PointDto dto) {
        return dto.getIsLeft()
                ? "-----|"
                : "     |";
    }

    private String toString(ResultsDto dto) {
        return dto.getResults().stream()
                .map(result -> toString(result))
                .reduce("", String::concat);
    }

    private String toString(ResultDto dto) {
        return addWhiteSpaces(dto.getResult());
    }

    private String addWhiteSpaces(String str) {
        String whitespaces = Stream.generate(() -> " ")
                .limit(STANDARD_LENGTH - str.length() + 1)
                .collect(Collectors.joining());
        return whitespaces + str;
    }
}
