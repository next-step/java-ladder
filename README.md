# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 2단계 - 사다리(생성)

### 1. Point
* boolean left / right 를 요소로 갖는다.
* direction enum 을 리턴한다.

### 2. Line 
* 사다리 게임에 라인
* List<Point> 를 가진다.
* 생성 시 connect 메서드로 포인트를 입력한다.
* true 값 뒤에는 true 가 또 나올 수 없으므로 validation 을 한다.

## 3. Ladder
* 사다리 라인을 그린다.

## 4. InputView
* 이름 리스트를 받는다. validation -> 5글자
* 최대 사다리 높이를 받는다. validation -> 숫자

## 5. ResultView
* 이름 리스트 뷰
* 사다리 뷰 -> boolean 리스트를 받아서 스트링 만들기

