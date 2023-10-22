package com.comments.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comments.entity.Comments;

@Repository
public interface CommentsRepo extends CrudRepository<Comments, Integer> {
	
	public List<Comments> findAllByStoryId(int id);
	
}
