package com.xcr.algorithm.labuladong.design;

import java.util.*;

/**
 * @Author: xia
 * @Date: 2021/1/21 10:31
 * @Version: v1.0
 */
public class Twitter {
    private static  int timestamp = 0;
    private static class Tweet {
        private int id;
        private int time;
        private Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }

    }
    private static class User {
        private int id;
        public Set<Integer> followed;
        public Tweet head;

        public User(int userId) {
            followed = new HashSet<>();
            this.id = userId;
            this.head = null;
        }

        public void follow(int userId) {
            followed.add(userId);
        }

        public void unfollow(int userId) {
            if (userId != this.id) {
                followed.remove(userId);
            }
        }

        public void post(int tweetId) {
            Tweet tweet = new Tweet(tweetId, timestamp);
            timestamp ++;
            tweet.next = head;
            head = tweet;
        }
    }

    private Map<Integer, User> userMap  = new HashMap<>();

    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId);
            userMap.put(userId, user);
        }
        User user = userMap.get(userId);
        user.post(tweetId);
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User user = new User(followerId);
            userMap.put(followerId, user);
        }
        if (!userMap.containsKey(followeeId)) {
            User user = new User(followeeId);
            userMap.put(followeeId, user);
        }
        userMap.get(followeeId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }

    public List<Integer> getNewFeeds(int userId) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> followed = userMap.get(userId).followed;

        PriorityQueue<Tweet> queue = new PriorityQueue<>(followed.size(), (a, b) -> {
            return b.time - a.time;
        });

        for(int id : followed) {
            Tweet head = userMap.get(id).head;
            if (head == null) continue;
            queue.add(head);
        }
        while (!queue.isEmpty()) {
            if (result.size() == 10) break;
            Tweet tweet = queue.poll();
            result.add(tweet.id);
            if (tweet.next != null) {
               queue.add(tweet.next);
            }
        }
        return result;
    }
}
