package me.birkheadc.twitterapi.tweet;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends CrudRepository<Tweet, Long> {

    @Query("SELECT t FROM Tweet t WHERE t.user.userName = :userName")
    public Iterable<Tweet> getAllByUserName(String userName);

    public Iterable<Tweet> findByUserOrderByTimeDesc(String user);

    public Iterable<Tweet> findAllByOrderByTimeDesc();
}
