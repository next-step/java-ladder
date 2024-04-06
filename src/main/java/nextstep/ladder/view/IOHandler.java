package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class IOHandler {

    private final InputView inputView;
    private final OutputView outputView;

    public IOHandler(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public List<Participant> insertParticipant(){
        outputView.printInputParticipants();
        return inputView.insertStrings()
                .stream()
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    public Height insertHeight(){
        outputView.printInputHeight();
        return new Height(inputView.insertInt());
    }

    public List<Destination> insertExecutionResults(){
        outputView.printInputExecutionResult();
        return inputView.insertStrings()
                .stream()
                .map(Destination::new)
                .collect(Collectors.toList());
    }

    private String insertViewer() {
        outputView.printInputViewer();
        return inputView.insertString();
    }
}
