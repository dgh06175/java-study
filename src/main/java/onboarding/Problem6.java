package onboarding;

import java.util.List;
import java.util.ArrayList;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for(List<String> form: forms) {
            if (validateAll(form.get(0), form.get(1))) return null;
            List<String> allNameTokens = new ArrayList<>();
            for(List<String> otherForm : forms) {
                if (form == otherForm){
                    continue;
                }
                allNameTokens.addAll(getNameTokens(otherForm.get(1)));
            }
            List<String> nameTokens = getNameTokens(form.get(1));
            for (String nameToken: nameTokens) {
                if (allNameTokens.contains(nameToken)) {
                    answer.add(form.get(0));
                    break;
                }
            }
        }

        //Collections.sort(answer);
        answer.sort(null);
        return answer;
    }

    // 문자열 이름을 받아서 연속된 두글자 토큰들을 추출하여 List로 반환
    private static List<String> getNameTokens(String name) {
        List<String> nameTokens = new ArrayList<>();
        for (int i = 0; i < name.length() - 1; i++) {
            nameTokens.add(name.substring(i, i+2));
        }
        return nameTokens;
    }


    /**
     * 이메일 형식과 이름 형식이 올바르면 true 반환
     * @param email String
     * @param name String
     * @return boolean
     */
    private static boolean validateAll(String email, String name) {
        return validateEmail(email) && validateName(name);
    }

    /**
     * 이메일 형식이 올바르면 true 반환
     * @param email String
     * @return boolean
     */
    private static boolean validateEmail(String email) {
        return email.contains("@email.com");
    }

    /**
     * 이름이 11자 이상 20자 미만이면 true 반환
     * @param name String
     * @return boolean
     */
    private static boolean validateName(String name) {
        return name.length() >= 11 && name.length() < 20;
    }
}
