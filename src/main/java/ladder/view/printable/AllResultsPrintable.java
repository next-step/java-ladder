package ladder.view.printable;

import ladder.dto.response.AllResultsDto;

public class AllResultsPrintable extends Printable {
    private final AllResultsDto dto;

    public AllResultsPrintable(AllResultsDto allResultsDto) {
        dto = allResultsDto;
    }

    @Override
    public void print() {
        println(dto.getAllResults()
                .entrySet()
                .stream()
                .map(entry -> entry.getKey().getName() + ": "
                        + entry.getValue().getResult())
                .reduce("", String::concat));
    }
}
