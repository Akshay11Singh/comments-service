package com.comments.controller;

import java.util.List;

import javax.xml.stream.events.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comments.messages.CommentError;
import com.comments.service.CommentsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="Comments Controller",description="Gives the comments about the user",produces="json",hidden=true)
public class CommentsController {

	@Autowired
	CommentsService commentsService;
	@Autowired
	CommentError commentError;

	@RequestMapping(value = "/comments/{id}")
	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@ApiOperation(value="Get Comments",response=Comment.class)
	public ResponseEntity<Object> getComments(@PathVariable("id") int id) {
		if (commentsService.getCommentsByID(id).isPresent()){
			return ResponseEntity.ok().body(commentsService.getCommentsByID(id).get());
		} else {
			commentError.setErrorMessage("Comments not Found");
		}
		return new ResponseEntity<>(commentError, HttpStatus.BAD_REQUEST);
	}

	@ApiResponses(value= {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@ApiOperation(value="Get Comments",response=Comment.class)
	
	@RequestMapping(value = "/storycomments/{id}")
	public ResponseEntity<Object> getStoryComments(@PathVariable("id") int id) {
		if(id>0)
		try {
			List list =commentsService.getCommentsByStoryId(id);
			if (!list.isEmpty()) {
				return ResponseEntity.ok().body(list);
			} else {
				commentError.setErrorMessage("Comments are Empty!!");
			}
		} catch (Exception e) {
			commentError.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(commentError, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else {
			commentError.setErrorMessage("bad request with id "+id);
		}
		return new ResponseEntity<>(commentError, HttpStatus.BAD_REQUEST);
	}
	@RequestMapping(value = "/storycommentsid/{id}")
	public ResponseEntity<Object> getStoryCommentsId(@PathVariable("id") int id) {
		if(id>0)
		try {
			List list =commentsService.getCommentsByStoryId(id);
			if (!list.isEmpty()) {
				return ResponseEntity.ok().body(list);
			} else {
				commentError.setErrorMessage("Comments are Empty!!");
			}
		} catch (Exception e) {
			commentError.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(commentError, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else {
			commentError.setErrorMessage("bad request with id "+id);
		}
		return new ResponseEntity<>(commentError, HttpStatus.BAD_REQUEST);
	}
}
