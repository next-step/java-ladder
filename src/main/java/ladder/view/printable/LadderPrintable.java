package ladder.view.printable;

import ladder.dto.response.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderPrintable extends Printable {
    private final LadderDto dto;

    public LadderPrintable(final LadderDto ladderDto) {
        dto = ladderDto;
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator());
        sb.append("실행결과");
        sb.append(System.lineSeparator());
        sb.append(System.lineSeparator());
        sb.append(toString(dto.getPersons()));
        sb.append(toString(dto.getLines()));
        println(sb);
    }

    private String toString(PersonsDto dto) {
        return dto.getPersons().stream()
                .map(person -> " " + toString(person))
                .reduce("", String::concat);
    }

    private String toString(PersonDto dto) {
        String name = dto.getName();
        String whitespaces = Stream.generate(() -> " ")
                .limit(dto.getStandardLength() - name.length())
                .collect(Collectors.joining());
        return whitespaces + name;
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
}

