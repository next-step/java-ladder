package step2.dto;

import java.util.List;

public class ResponseMembersDTO {
    private final List<String> memberNames;

    public ResponseMembersDTO(List<String> memberNames) {
        this.memberNames = memberNames;
    }

    public List<String> getMemberNames() {
        return memberNames;
    }
}
