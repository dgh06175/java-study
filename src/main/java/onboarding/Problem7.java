package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, ArrayList<String>> friendships = addFriendShips(friends);
        HashMap<String, Integer> friendRatings = initFriendRatings(friends, visitors);

        addVisitorRating(friendRatings, visitors);

        addFriendShipsRating(user, friendRatings, friendships);
        friendRatings.put(user, 0);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(friendRatings.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        System.out.println(list);
        int count = 5;
        for(Map.Entry<String, Integer> entry: list) {
            if (count-- == 0) break;
            answer.add(entry.getKey());
        }

        for (String f: friendships.get(user)) {
            answer.remove(f);
        }
        return answer;
    }

    private static HashMap<String, ArrayList<String>> addFriendShips(List<List<String>> friends) {
        HashMap<String, ArrayList<String>> friendships = new HashMap<>();
        for (List<String> friend: friends) {
            String firstFriend = friend.get(0);
            String secondFriend = friend.get(1);

            addHash(friendships, firstFriend, secondFriend);
            addHash(friendships, secondFriend, firstFriend);
        }
        return friendships;
    }

    private static void addHash(HashMap<String, ArrayList<String>> friendships, String firstFriend, String secondFriend) {
        if (!friendships.containsKey(firstFriend)) {
            friendships.put(firstFriend, new ArrayList<>(List.of(secondFriend)));
        } else {
            friendships.get(firstFriend).add(secondFriend);
        }
    }

    private static HashMap<String, Integer> initFriendRatings(List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> friendRatings = new HashMap<>();
        for(List <String> friend: friends) {
            String firstName = friend.get(0);
            String secondName = friend.get(1);
            if (!friendRatings.containsKey(firstName)) friendRatings.put(firstName, 0);
            if (!friendRatings.containsKey(secondName)) friendRatings.put(secondName, 0);
        }

        for(String visitor: visitors) {
            if (!friendRatings.containsKey(visitor)) friendRatings.put(visitor, 0);
        }
        return friendRatings;
    }

    private static void addVisitorRating(HashMap<String, Integer> friendRatings, List<String> visitors) {
        for (String visitor: visitors) {
            friendRatings.put(visitor, friendRatings.get(visitor) + 1);
        }
    }

    private static void addFriendShipsRating(String user, HashMap<String, Integer> friendRatings, HashMap<String, ArrayList<String>> friendships) {
        ArrayList<String> userFriend = friendships.get(user);
        for (String friend: friendships.keySet()) {
            for (String friendsfriend: friendships.get(friend)) {
                if (userFriend.contains(friendsfriend)) {
                    friendRatings.put(friend, friendRatings.get(friend) + 10);
                }
            }
        }
    }
}
