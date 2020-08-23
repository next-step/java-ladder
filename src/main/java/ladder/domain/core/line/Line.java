package ladder.domain.core.line;


import ladder.domain.core.line.name.Name;
import ladder.domain.core.line.name.Names;
import ladder.ui.result.DisplayResult;

public interface Line {

    default int indexOf(String name) {
        throw new UnsupportedOperationException();
    }

    default int indexOf(int index) {
        throw new UnsupportedOperationException();
    }

    default String getResult(int index) {
        throw new UnsupportedOperationException();
    }

    int getWidth();

    default Names<? extends Name> getNames(){
        throw new UnsupportedOperationException();
    }

    DisplayResult toDisplayResult();
}
