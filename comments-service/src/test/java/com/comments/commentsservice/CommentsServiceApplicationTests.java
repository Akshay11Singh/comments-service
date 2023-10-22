package com.comments.commentsservice;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.comments.controller.CommentsController;
import com.comments.entity.Comments;
import com.comments.repository.CommentsRepo;
import com.comments.service.CommentsService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CommentsServiceApplicationTests {

	@Autowired
	CommentsService commentsService;

	@Autowired
	CommentsRepo commentsRepo;

	@Autowired
	CommentsController commentsController;

	@Mock
	List list;

	@Spy
	Comments comments;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetComments() throws Exception {

		when(commentsRepo.findAllByStoryId(anyInt())).thenReturn(list);
		when(commentsService.getCommentsByID((anyInt()))).thenReturn(Optional.of(comments));
		mockMvc.perform(get("/comments/1")).andDo(print()).andExpect(status().isOk());
		assertNotNull(commentsController.getComments(anyInt()));

	}

	
}
