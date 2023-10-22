package com.comments.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comments {
	
	@Id
	public Integer id;
	public Integer storyId;
	public String userName;
	public String comment;
	public String commentDate;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the storyId
	 */
	public Integer getStoryId() {
		return storyId;
	}
	/**
	 * @param storyId the storyId to set
	 */
	public void setStoryId(Integer storyId) {
		this.storyId = storyId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return the commentDate
	 */
	public String getCommentDate() {
		return commentDate;
	}
	/**
	 * @param commentDate the commentDate to set
	 */
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Comments [id=" + id + ", storyId=" + storyId + ", userName=" + userName + ", comment=" + comment
				+ ", commentDate=" + commentDate + "]";
	}
	
	
	

}
