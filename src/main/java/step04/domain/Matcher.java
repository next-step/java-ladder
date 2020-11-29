package step04.domain;

import exception.NotMatchedCountException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Matcher {
    private final NamesOfParticipant namesOfParticipant;
    private final NamesOfResult namesOfResult;
    private final List<Integer> matchedTable;

    private Matcher(Builder builder) {
        this.namesOfParticipant = builder.namesOfParticipant;
        this.namesOfResult = builder.namesOfResult;
        this.matchedTable = builder.matchedTable;
    }


    public static class Builder {
        private final NamesOfParticipant namesOfParticipant;
        private NamesOfResult namesOfResult;
        private List<Integer> matchedTable;

        private Builder(NamesOfParticipant namesOfParticipant) {
            this.namesOfParticipant = namesOfParticipant;
        }

        public static Builder of(NamesOfParticipant namesOfParticipant) {
            return new Builder(namesOfParticipant);
        }

        public Builder namesOfResult(NamesOfResult namesOfResult) {
            this.namesOfResult = namesOfResult;
            validateCount(namesOfParticipant.size(), namesOfResult.size());
            return this;
        }

        public Builder matchedTable(List<Integer> matchedTable) {
            this.matchedTable = matchedTable;
            validateCount(namesOfParticipant.size(), matchedTable.size());
            return this;
        }

        public Matcher build() {
            return new Matcher(this);
        }

        private void validateCount(int count1, int count2) {
            if (count1 != count2) {
                throw new NotMatchedCountException();
            }
        }

    }

    public Name getResultByParticipant(Name nameOfParticipant) {
        int indexOfName = namesOfParticipant.indexOf(nameOfParticipant);
        int indexOfMatched = matchedTable.indexOf(indexOfName);
        return namesOfResult.getNames().get(indexOfMatched);
    }

    public Map<Name, Name> getResults() {
        Map<Name, Name> map = new HashMap<>();

        List<Name> namesOfParticipant = this.namesOfParticipant.getNames();
        List<Name> namesOfResult2 = namesOfResult.getNames();

        for (int i = 0; i < this.namesOfParticipant.size(); i++) {
            int targetIndex = matchedTable.indexOf(i);
            map.put(namesOfParticipant.get(i), namesOfResult2.get(targetIndex));
        }

        return map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matcher matcher = (Matcher) o;
        return Objects.equals(namesOfParticipant, matcher.namesOfParticipant) &&
                Objects.equals(namesOfResult, matcher.namesOfResult) &&
                Objects.equals(matchedTable, matcher.matchedTable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namesOfParticipant, namesOfResult, matchedTable);
    }
}
