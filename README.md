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
* boolean left / current, Integer index 를 요소로 갖는다.
* first 메서드 : 처음 생성
* next 메서드 : 처음 생성 이후 실행 인덱스 증가 및 다음 값 저장
* last 메서드 : 마지막 값 생성 current false 고정

### 2. Name
* 입력 받은 이름 저장

### 3. Line 
* 생성 사람의 수를 받고 Point 생성
* 포인트 현재 값 리턴

## 4. Ladder
* 이름 리스트 / 라인 리스트 보관

## 5. InputView
* 이름 리스트를 받는다. validation -> 5글자
* 최대 사다리 높이를 받는다. validation -> 숫자

## 6. ResultView
* 이름 리스트 뷰
* 사다리 뷰 -> boolean 리스트를 받아서 스트링 만들기

