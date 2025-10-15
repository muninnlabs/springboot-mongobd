package com.munninlabs.springmongo.repository;

import com.munninlabs.springmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> findByTitle(String text);

    @Query("{ $and: [ { date: { $gte: ?1 } }, { date: { $lte: ?2 } }, { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'author.name': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);

    List<Post> findByTitleContainingIgnoreCase(String text);
}
