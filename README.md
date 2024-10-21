# 사다리 게임

## 진행 방법

* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## Step1. 기능 구현

* 익명 클래스를 람다로 전환
* 람다를 활용해 중복 제거
* map, reduce, filter 실습 1
    * filter, reduce 사용
* map, reduce, filter 실습 2
    * filter, distinct, limit, map, sorted 사용
* Optional을 활용해 조건에 따른 반환
    * Optional.ofNullable 사용
* Optional에서 값 반환
    * orElse 사용
* Optional에서 exception 처리
    * orThrowElse 사용

## Step1. 피드백 구현

* FunctionalInterface 추가
* filter 로직 메소드 분리

## Step2. 요구 사항

* 사다리 게임을 참가하는 사람의 이름을 부여한다. (최대 5글자)
* 사다리를 출력할 때 사람 이름도 같이 출력한다.
* 사람 이름은 ,를 기준으로 구분한다.
* 사람 이름에 따라 사다리 폭이 넓어진다.
* 사다리 라인이 겹치지 않아야 한다.

## Step2. 피드백 구현

- [x] ToString -> Getter 변경
- [x] 매직넘버 상수분리
- [x] Member 정상 케이스 테스트 작성
- [x] 상수는 생성자 위에 위치
- [x] 생성자 private으로 수정
- [x] public, private 위치 조정
- [x] 객체 내부 메소드 private으로 수정 및 테스트 추가
- [X] private 메소드에 static 삭제
- [X] 일급 컬렉션에 없는 index면 exception 발생
- [X] 컨트롤러 단으로 생성 전략 이동

## Step3. 요구 사항

* 사다리 실행 결과를 입력한다.
* 생성된 사다리를 기준으로 게임을 실행해 결과를 만든다.
* 결과를 보고 싶은 사람을 개인으로 입력하면 개인의 결과를 가져온다.
* 결과를 보고 싶은 사람을 all을 입력하면 전체의 결과를 출력한다.

## Step3. 기능구현

- [X] 사다리 실행 결과 입력
- [X] 사다리 결과 생성
- [X] 사다리 결과 출력 (개인)
- [X] 사다리 결과 출력 (전체)