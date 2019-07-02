# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## step2. 기능목록
* 게임 참여자 구하기
    * 사람 이름을 쉼표(,) 기준으로 자른다
    * 게임 참여자는 최소 1명 -> 이름으로 인정되는 문자열 최소 1개
    * 사람 이름은 최소 1글자 최대 5자로 한다.
        * pobi -> 이름 인정
        * p -> 이름 인정
        * 빈문자열 또는 공백문자열 -> error (StringUtils.isBlank(..) 이용)
        * pobibi -> error (length 5 초과)
* 사다리 개수 구하기
    * 게임 참여자 0명 -> error
    * 게임 참여자 1명 -> error (사다리 게임이므로 1명도 에러로 처리합니다.)
    * 게임 참여자 2명 -> 1개 -> point[0]
    * 게임 참여자 3명 -> 2개 -> point[0], point[1]
    * 게임 참여자 4명 -> 3개 -> point[0], point[1], point[2]
    * 게임 참여자 5명 -> 4개 -> point[0], point[1], point[2], point[3]
    * ...
    * 게임 참여자 2명부터 규칙적으로 사다리 개수가 생성
* 사다리 높이 입력값
    * NUMBER_REGEX = "^[0-9]*$"
    * 숫자형의 String 입력
    * 숫자형이 아닌 문자열입력 
* 사다리 구성
    * 사다리 개수 + 사다리 높이 
    * 사다리 높이 1개 Line -> 여러개의 사다리 개수 List<Boolean> points
    * 사다리 Ladder -> 여러개 높이 List<Line> Lines
    * 사다리 구분 '|' -> 게임 참여자 명수 개수와 동일
    * 마지막 명수에 해당하는 '|' 을 그리면, 
      사다리를 그리지 않고,
      그 다음 높이(Line)로 이동한다.
    * 사다리를 그리는 것은 Boolean 형의 point 가 true 일 때만 그린다.
    * List<Boolean> points 에서 이전의 point 가 true 일 경우,
      그 다음 point는 반드시 false 가 온다.
    * List<Boolean> points 에서 이전의 point 가 false 일 경우,
      그 다음 point는 true 또는 false 둘 중 랜덤하게 결정 된다.
    * List<Boolean> 의 가장 처음 point 의 값은 랜덤하게 true 또는 false 가 된다.
* 사다리를 이름과 함께 출력
    * 이름을 출력할 때 
      이름을 출력하고 
      이름의 길이가 5가 안될 경우, 
      모자란 길이 만큼 공백문자열을 출력 후
      이름을 출력 한 뒤,
      그 다음 참여자 출력시 하나의 공백문자열을 두고 출력한다.
        * _pobi honux crong ___jk
    * 사다리를 출력 할 때
      공백문자열 다섯개를 먼저 출력 후,
      참여자 구분 '|' 출력 한 뒤,
      사다리 '-----' 를 출력 한 뒤
      그 다음 참여자 구분 '|' 출력 한 뒤,
      다음 라인으로 이동한다.