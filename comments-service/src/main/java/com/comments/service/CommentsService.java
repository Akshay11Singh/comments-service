package com.comments.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comments.entity.Comments;
import com.comments.messages.CommentError;
import com.comments.repository.CommentsRepo;

@Service
public class CommentsService {

	@Autowired
	CommentsRepo commentsRepo;
	@Autowired
	CommentError commentError;

	public Optional<Comments> getCommentsByID(int id) {
		return commentsRepo.findById(id);
	}

	public List<Comments>getCommentsByStoryId(int id) throws Exception{
		
		List listCommenst=new ArrayList();
	/*	if(!commentsRepo.findAllByStoryId(id).isEmpty())
		commentsRepo.findAllByStoryId(id).forEach(t->listCommenst.add(t.getComment()));
		else {
			commentError.setErrorMessage("No comments found for story id "+id);
		}
		return listCommenst;
	*/
		if(!commentsRepo.findAllByStoryId(id).isEmpty())
			return commentsRepo.findAllByStoryId(id); 
			else {
				commentError.setErrorMessage("No comments found for story id "+id);
			}
			return listCommenst;
		
		}
}
