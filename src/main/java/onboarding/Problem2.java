package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        int len = cryptogram.length();
        for(int i = 0; i < len - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i+2);
                len -= 2; // 문자열 길이 2만큼 줄었으므로 인덱스 에러 방지 위해 2 빼줌
                i -= 2; // 문자가 지워지면서 이전 인덱스에서 중복 글자가 발생할 수 있으므로 인덱스 2만큼 돌아감
                // System.out.println(cryptogram);
            }
        }
        return cryptogram;
    }
}
