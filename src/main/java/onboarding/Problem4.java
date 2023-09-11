package onboarding;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int len = alpha.length() - 1;
        System.out.println(len);
        for (int i = 0; i < word.length(); i++) {
            boolean isUpper = Character.isUpperCase(word.charAt(i));
            int index = alpha.indexOf(Character.toLowerCase(word.charAt(i)));
            if (index == -1) {
                answer.append(" ");
                continue;
            }
            if (isUpper) answer.append(Character.toUpperCase(alpha.charAt(len - index)));
            else answer.append(alpha.charAt(len - index));
        }

        return answer.toString();
    }
}
