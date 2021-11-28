# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)


## 기능목록
- input view
- output view
- LadderInformation
  - 사다리를 생성하는데 필요한 height , width 값을 가진다.
- GameInformation  
  - Game과 관련된 Names 를 가진다.
- ladder
- line
  - line 생성(연속으로 true가 나올 수 없다.)
  - 사람 수 - 1 만큼의 배열만 생성 된다.
- lines
  - line의 1급객체
- bridge
  - boolean value 를 갖는다
  - isGo() 메서드는 가진 값에 따라 true / false 반환
  - getCachedPoint() 미리 생성 된 bridge 를 반환한다.
- Name
  - 이름의 크기는 최소 1자 최대 5자이다.
  - null 값이나 empty 값이 올 수 없다.
- Names
  - Name의 1급 객체  
- LadderInformation
  - input 받은 값을 전달하는 객체
- Height
  - 사다리의 높이값을 가지는 객체
- Width
  - 사다리의 넓이 값을 가지는 객체
  - getEndLine() width 보다 -1 을 해준 값을 리턴한다.
