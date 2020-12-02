package step04.domain;

import exception.NotMatchedCountException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MatcherOfResult {
    private final NamesOfParticipant namesOfParticipant;
    private final NamesOfResult namesOfResult;
    private final TableOfResult tableOfResult;

    private MatcherOfResult(Builder builder) {
        this.namesOfParticipant = builder.namesOfParticipant;
        this.namesOfResult = builder.namesOfResult;
        this.tableOfResult = builder.tableOfResult;
    }


    public static class Builder {
        private final NamesOfParticipant namesOfParticipant;
        private NamesOfResult namesOfResult;
        private TableOfResult tableOfResult;

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

        public Builder tableOfResult(TableOfResult tableOfResult) {
            this.tableOfResult = tableOfResult;
            validateCount(namesOfParticipant.size(), tableOfResult.size());
            return this;
        }

        public MatcherOfResult build() {
            return new MatcherOfResult(this);
        }

        private void validateCount(int count1, int count2) {
            if (count1 != count2) {
                throw new NotMatchedCountException();
            }
        }

    }

    public Name getResultByParticipant(Name nameOfParticipant) {
        int indexOfName = namesOfParticipant.indexOf(nameOfParticipant);
        int indexOfMatched = tableOfResult.indexOf(indexOfName);
        return namesOfResult.getNames().get(indexOfMatched);
    }

    public Map<Name, Name> getResults() {
        Map<Name, Name> map = new HashMap<>();

        List<Name> namesOfParticipant = this.namesOfParticipant.getNames();
        List<Name> namesOfResult2 = namesOfResult.getNames();

        for (int i = 0; i < this.namesOfParticipant.size(); i++) {
            int targetIndex = tableOfResult.indexOf(i);
            map.put(namesOfParticipant.get(i), namesOfResult2.get(targetIndex));
        }

        return map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatcherOfResult matcherOfResult = (MatcherOfResult) o;
        return Objects.equals(namesOfParticipant, matcherOfResult.namesOfParticipant) &&
                Objects.equals(namesOfResult, matcherOfResult.namesOfResult) &&
                Objects.equals(tableOfResult, matcherOfResult.tableOfResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namesOfParticipant, namesOfResult, tableOfResult);
    }
}
