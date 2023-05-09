package ladder.domain;

import java.util.Objects;

public class ResultName {

	private final String resultName;

	public ResultName(Names names, String input) {
		String trim = input.trim();
		if (trim.equals("all")) {
			this.resultName = trim;
			return;
		}
		if (names.isExist(new Name(trim)) == false) {
			throw new IllegalArgumentException("존재하지 않는 참가자 입니다.");
		}
		this.resultName = trim;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResultName that = (ResultName)o;
		return Objects.equals(resultName, that.resultName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(resultName);
	}
}
