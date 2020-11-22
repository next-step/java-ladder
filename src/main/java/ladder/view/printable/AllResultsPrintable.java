package ladder.view.printable;

import ladder.dto.AllResultsDto;
import ladder.dto.PersonDto;
import ladder.dto.ResultDto;

import java.util.List;
import java.util.stream.IntStream;

public class AllResultsPrintable extends Printable {
    private final AllResultsDto dto;

    public AllResultsPrintable(AllResultsDto allResultsDto) {
        dto = allResultsDto;
    }

    @Override
    public void print() {
        List<PersonDto> persons = dto.getPersonsDto().getPersons();
        List<ResultDto> results = dto.getResultsDto().getResults();
        int sizeOfPersons = dto.getPersonsDto().getPersons().size();

        println(System.lineSeparator() + "실행 결과");
        IntStream.range(0, sizeOfPersons)
                .forEach(position -> println(
                        persons.get(position).getName() + ": "
                                + results.get(position).getResult()
                ));
    }
}
