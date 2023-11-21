package me.namuhuchutong.ladder.domain;

import me.namuhuchutong.ladder.domain.wrapper.Name;
import me.namuhuchutong.ladder.domain.wrapper.OddNumber;
import me.namuhuchutong.ladder.domain.wrapper.Result;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.Map.*;
import static java.util.stream.Collectors.*;

public class Ladder {

    private final Rows rows;

    private final Names names;

    private final Results results;

    public Ladder(Rows rows, Names names, Results results) {
        this.rows = rows;
        this.names = names;
        this.results = results;
    }

    public NameAndResult startLadderGame() {
        OddConvertor oddConvertor = new OddConvertor(names.size());
        LadderGameResultSequence sequence = names.stream()
                                                .map(name -> oddConvertor.convert(names.getSequence(name)))
                                                .map(rows::move)
                                                .collect(collectingAndThen(toUnmodifiableList(),
                                                                           LadderGameResultSequence::new));
        return linkNameAndResult(sequence);
    }

    private NameAndResult linkNameAndResult(LadderGameResultSequence sequence) {
        Map<Name, Result> collect = names.stream()
                                         .map(names::getSequence)
                                         .map(integer -> entry(names.getNthName(integer),
                                                                   results.getNthResult(sequence.convert(integer))))
                                         .collect(toMap(Entry::getKey, Entry::getValue));
        return new NameAndResult(collect);
    }

    static class OddConvertor {

        private final List<OddNumber> convertedNumbers;

        public OddConvertor(int size) {
            this.convertedNumbers = IntStream.range(0, size * 2)
                                             .map(i -> i * 2 + 1)
                                             .mapToObj(OddNumber::new)
                                             .collect(toList());
        }

        public int convert(int sequence) {
            return getOdd(sequence);
        }

        private int getOdd(int sequence) {
            return convertedNumbers.get(sequence)
                                   .getOdd();
        }
    }
}
