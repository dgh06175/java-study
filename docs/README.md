# 미션 - 숫자 야구

## 기능 목록

- [x] 게임 시작 문구 출력
- [ ] 입력 받을때 설명 출력
- [ ] 서로 다른 3자리의 수 입력
- [ ] 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시
- [ ] 하나도 없는 경우
- [ ] 3개의 숫자를 모두 맞힐 경우
- [x] 게임이 끝난 경우 재시작/종료를 구분 하는 1과 2중 하나의 수

## 추가 요구 사항

- [ ] [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java) 가이드 준수
- [ ] indent depth 2까지 허용 (while 안에 if문)
- [x] 3항 연산자 쓰지 않기
- [ ] 함수가 한가지 일만 하도록 최대한 작게 만들기
- [ ] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인 (`test/java/study` 학습 하기)
- [ ] [커밋 메세지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고하여 커밋 메세지 작성, 위 기능 목록 단위로 커밋

# 학습 정리

## 커밋 메세지

```
<type>(<scope>): <subject>

<body>

<footer>
```

### `<type>`

  - feat (기능)
  - fix (버그 수정)
  - docs (문서)
  - style (형식 변경, 놓친 세미콜론, …)
  - refactor (리팩터링)
  - test (테스트 추가)
  - chore (패키지, 환경설정)
  - rename (파일 혹은 폴더명 수정 혹은 이동)
  - remove (파일 삭제)

### `<subject>`

- **간략하게** 변경 이유와 이 커밋으로 어떤 점이 달라지는지 명시합니다.
- 명령형, 현재형으로 작성합니다. (변경함: X, 변경됨: X, 변경: O)
- 끝에 점(.)을 붙이지 않습니다.

### `<body>`

- 긴 설명이 필요한 경우 작성
- 명령형, 현재형으로 작성합니다. (변경함: X, 변경됨: X, 변경: O)
- 무엇을 왜 변경했는지 동기를 작성
- 길이를 줄이지 말고 상세하게 작성

### `<footer>`

- 큰 변화가 있을 경우 상세하게 적는다.
- 버그를 닫을때 버그의 번호와 함께 작성한다. `Closes #234, #992`


# 구글 스타일 JAVA 컨벤션

## Formatting

### enum

- enum 상수의 각 `,` 다음의 개행 허용, 추가로 하나까지 더 허용

```java
private enum Answer {
  YES {
    @Override public String toString() {
      return "yes";
    }
  },

  NO,
  MAYBE
}
```

```java
private enum Suit { CLUBS, HEARTS, SPADES, DIAMONDS }
```

### 변수

- 매 초기화 마다 하나의 변수만 초기화한다. (`int a, b;` 금지) (for문 헤더 제외)
- 지역변수는 굳이 블럭이 시작될때 선언할 필요는 없다. 처음 사용되는 위치와 가깝게 선언한다.
- `String args[]` 대신에 `String[] args` 사용.

### 배열

"block like construct" 처럼 포매팅 가능하다. 모두 허용
```java
new int[] {           new int[] {
  0, 1, 2, 3            0,
}                       1,
                        2,
new int[] {             3,
  0, 1,               }
  2, 3
}                     new int[]
                          {0, 1, 2, 3}
```

### switch

- switch 블럭의 들여쓰기는 +2(4) 이다.
- break가 없는 case의 경우 주석으로 표시해도 좋다.

### 애노테이션

- 애노테이션은 클래스, 함수, 생성자 바로 위에 작성하지만, 한줄에 써도 된다.
```java
@Override
@Nullable
public String getNameIfPresent() { ... }

@Override public int hashCode() { ... }
```

- @Override: 생략하지 않는다.
(부모 메서드가 @Deprecated 인 경우 생략 가능)

## 네이밍

- 모든 식별자는 ASCII 숫자와 문자와 `_`를 쓴다. 고로 정규식 `\w+` 와 매칭된다.

### 패키지

- 전부 소문자로 연속된 단어로 이룬다. (com.example.deepspace)

### 클래스

- 클래스 이름은 UpperCamelCase로 작성 (LottoNumber)
- 클래스 이름은 명사 또는 명사구 (Character, ImmutableList)
- 인터페이스 이름은 추가로 형용사 또는 형용사 구 (Readable, Testable)
- 테스트 중인 클래스 이름은 마지막에 Test 붙여주기. (HashTest)

### 메소드 (함수)

- 메소드 이름은 lowerCamelCase로 작성 (validateInput)
- 메소드 이름은 동사 또는 동사구 (sendMessage, stop)

### Constant (상수)

- 상수 이름은 CONSTANT_CASE를 사용 (MAX_INDEX)
- 상수 이름은 일반적으로 명사 또는 명사구
- final 이라도 상태가 변경될수 있는 인스턴스라면 상수가 아니다.

### 상수가 아닌 필드 변수, 매개변수, 지역변수 이름

- 상수가 아닌 필드 이름은 lowerCamelCase로 작성한다.
- 일반적으로 명사 또는 명사구 (addedValues, index)
- final, 불변인 경우에도 지역 변수는 상수로 간주되지 않는다.

### Type 변수 이름

- 각 유형 변수의 이름은 단일 대문자 혹은 단일 숫자가 따라올 수 있다. (E, T, X, T2)
- 클래스에 사용되는 형식의 이름 뒤에 대문자 T를 붙힌다. (RequestT, FooT)

### 정의된 단어들에 이름을 붙힐 때 (IPv6, ASCII, iOS)

- 단어로 나누고 UpperCamelCase 또는 lowerCamelCase 적용
- (XML HTTP request -> XmlHttpRequest)
- (new customer ID -> newCustomerId)
- (supports IPv6 on iOS? -> supportsIpv6OnIos)

### Javadoc 형식
```java
/**
 * Multiple lines of Javadoc text are written here,
 * wrapped normally...
 */
public int method(String p1) { ... }
```

```java
/** 짧은 Javadoc 입니다. */
```

### Javadoc 을 어디에 써야하는가

- 모든 public class에 쓰이고, 그 클래스의 public, protected 멤버에 쓰인다. (너무 간단한 경우 제외)


## 자바 기본 문법

### 배열

**선언**

```java
int[] score = new int[5];
```

`int[] score` -> 생성된 배열을 다루기 위한 참조변수를 저장하기 위한 공간이 만들어짐
`new int[5]` -> 타입과 길이를 지정한 배열 생성 (실제 저장공간)

```java
int[] score = new int[5] { 50, 60, 70, 80, 90 }; // 생성과 초기화 동시에
int[] score1 = { 50, 60, 70, 80, 90 }; // 생성시에는 new int[] 생략 가능
int[] score2;
// score2 = { 10, 20 ,30, 40 ,50 }; // 불가능. 이때는 {} 앞에 new int[] 붙혀야함
```

배열을 선언과 생성을 동시에 할 경우를 제외하고, `{ 10, 20 ,30, 40 ,50 }` 는 사용 불가능하다. (매개변수 전달 등..)<br>
`new int[5] { 10, 20 ,30, 40 ,50 }` 처럼 사용해줘야 한다.


**길이**

`배열이름.length` -> 배열의 길이 반환

**배열 형식대로 문자열로 바꾸기**

`Arrays.toString(배열이름)` (import java.util.*) <br>
-> 배열 `{ 100, 95 }`를 `"[100, 95]"` 문자열로 바꾼다.

**println**

char 배열은 바로 출력해도 문자들만 출력된다.
```java
char[] chArr = { 'a', 'b', 'c', 'd' };
Sysyem.out.println(chArr);
// abcd 출력됨
```

**배열 복사**

```java
int[] num = { 1, 2, 3 };
int[] newNum = new int[num.length];
System.arraycopy(num, 0, newNum, 0, num.length);
// num[0] 에서 newNum[0] 으로 num.length 개의 데이터를 복사
```

### 랜덤

`Math.random()` -> 0.0 이상, 1.0 미만의 숫자 반환

`(int)(Math.random() * m) + n` -> n 부터 m 까지의 정수 반환

### 컬렉션 (Collection)
https://velog.io/@dgh06175/Java-Collection-%ED%94%84%EB%A0%88%EC%9E%84%EC%9B%8C%ED%81%AC

블로그에 저장했습니다.



### Integer vs int

### 문자열 다루기

