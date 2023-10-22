package com.comments.commentsservice;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.comments.controller.CommentsController;
import com.comments.entity.Comments;
import com.comments.repository.CommentsRepo;
import com.comments.service.CommentsService;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class CommentsServiceApplicationTests {

	@Mock
	CommentsService commentsService;

	@Mock
	CommentsRepo commentsRepo;

	@Mock
	CommentsController commentsController;

	@Mock
	List list;

	@Spy
	Comments comments;

	private static final String output = "{\"id\":1,\"storyId\":1,\"userName\":\"Akshay11Singh\",\"comment\":\"Akshay Singh\",\"commentDate\":\"26-10-2023\"}";  
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetComments() throws Exception {

		when(commentsRepo.findAllByStoryId(anyInt())).thenReturn(list);
		when(commentsService.getCommentsByID((anyInt()))).thenReturn(Optional.of(comments));
		assertNotNull(mockMvc.perform(get("/comments/1")).andDo(print()).andExpect(status().isOk()).andReturn()
				.getResponse().getContentAsString());
		assertEquals(output, mockMvc.perform(get("/comments/1")).andDo(print()).andExpect(status().isOk()).andReturn()
				.getResponse().getContentAsString());

	}

}
