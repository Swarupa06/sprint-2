package com.spring.swagger.ovs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.spring.ovs.dtos.ElectionResult;
import com.spring.ovs.service.ElectionResultService;


public class ElectionResultTest {

	ElectionResultService service=mock(ElectionResultService.class);
	  ElectionResult result=new ElectionResult();
		
		@Test
		void testAddResult() 
		{
			
			when(service.addElectionResult(result)).thenReturn(result.getId());
			assertEquals(result.getId(),service.addElectionResult(result));
			
		}
}
