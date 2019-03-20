package com.ucc.dc.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;

import com.ucc.dc.servlets.InsertTask;

public class InsertTaskTest extends Mockito{

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() throws IOException, ServletException {
		//fail("Not yet implemented");
		HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("type")).thenReturn("web");
        when(request.getParameter("deadline")).thenReturn("2000");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new InsertTask().doPost(request, response);

        verify(request, atLeast(1)).getParameter("type"); // only if you want to verify username was called...
        writer.flush(); // it may not have been flushed yet...
        assertTrue(stringWriter.toString().contains("serverId"));
	}

}
