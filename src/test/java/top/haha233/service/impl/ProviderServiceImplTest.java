package top.haha233.service.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import top.haha233.service.ProviderService;
import top.haha233.util.Response;

/**
 * ProviderServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
public class ProviderServiceImplTest {
	private ProviderService ps;
	@Before
	public void before() throws Exception {
		ps= new ProviderServiceImpl();
	}

	@After
	public void after() throws Exception {
	}

	/**
	 * Method: query()
	 */
	@Test
	public void testQuery() throws Exception {
//TODO: Test goes here...
		Response response = ps.query();
		System.out.println(response.get("providers"));
		Assert.assertEquals(0,response.get("status"));
	}

	/**
	 * Method: queryById(String id)
	 */
	@Test
	public void testQueryById() throws Exception {
//TODO: Test goes here...
		Response response = ps.queryById("14");
		System.out.println(response.get("provider"));
		Assert.assertEquals(0,response.get("status"));
	}


} 
