package top.haha233.service.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import top.haha233.service.BillService;
import top.haha233.util.Response;

/**
 * BillServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
public class BillServiceImplTest {
	private BillService bs;
	@Before
	public void before() throws Exception {
		bs = new BillServiceImpl();
	}

	@After
	public void after() throws Exception {
	}

	/**
	 * Method: add(String billCode, String productName, String productDesc, String productUnit, String productCount, String totalPrice, String isPayment, String providerId)
	 */
	@Test
	public void testAdd() throws Exception {
//TODO: Test goes here...
//		Response response = bs.add("11","11","11","11","11","11","11","11");
//		Assert.assertEquals(0,response.get("status"));
	}

	/**
	 * Method: update(String billCode, String productName, String productDesc, String productUnit, String productCount, String totalPrice, String isPayment, String providerId, String id)
	 */
	@Test
	public void testUpdate() throws Exception {
//TODO: Test goes here...
		Response response = bs.update(null,null,"11","11","11","11","11","14","19");
		Assert.assertEquals(0,response.get("status"));
	}

	/**
	 * Method: delete(String id)
	 */
	@Test
	public void testDelete() throws Exception {
//TODO: Test goes here...
//		Response response = bs.delete("19");
//		Assert.assertEquals(0,response.get("status"));
	}

	/**
	 * Method: query(String billCode, String productName, String productDesc, String productUnit, String productCount, String totalPrice, String isPayment, String providerId)
	 */
	@Test
	public void testQuery() throws Exception {
//TODO: Test goes here...
		Response response = bs.query(null,"洗发水",null,null,null,null,null,null,"1","3");
		System.out.println(response.get("bills"));
		Assert.assertEquals(0,response.get("status"));
	}

	/**
	 * Method: queryById(String id)
	 */
	@Test
	public void testQueryById() throws Exception {
//TODO: Test goes here...
//		Response response = bs.queryById("1");
//		System.out.println(response.get("bill"));
//		Assert.assertEquals(0,response.get("status"));
	}


} 
