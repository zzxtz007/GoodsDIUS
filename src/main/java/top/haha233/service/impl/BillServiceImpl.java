package top.haha233.service.impl;

import org.apache.ibatis.session.SqlSession;
import top.haha233.dal.BillMapper;
import top.haha233.model.bo.BillBo;
import top.haha233.model.po.BillPo;
import top.haha233.service.BillService;
import top.haha233.util.Response;
import top.haha233.utils.MyBatisUtil;

import java.util.List;

/**
 * @author Ice_Dog
 */
public class BillServiceImpl implements BillService {
	/**
	 * 状态码设置规范
	 * 0 操作成功 + 可能需要返回相应的模型
	 * 1 未登录
	 * 2 传入值含有空值
	 * 3 类型转换错误
	 * 4 数据库操作错误
	 * 5 传出数据为空
	 */

	@Override
	public Response add(String billCode, String productName, String productDesc, String productUnit,
			String productCount, String totalPrice, String isPayment, String providerId) {
		//2 传入值含有空值
		if (billCode == null || productName == null || productDesc == null || productUnit == null || productCount == null || totalPrice == null || isPayment == null || providerId == null) {
			return new Response(2);
		}
		Double newProductCount;
		Double newTotalPrice;
		Integer newIsPayment;
		Long newProviderId;
		//3 类型转换错误
		try {
			newProductCount = Double.parseDouble(productCount);
			newTotalPrice = Double.parseDouble(totalPrice);
			newIsPayment = Integer.parseInt(isPayment);
			newProviderId = Long.parseLong(providerId);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(3);
		}
		BillPo bill = new BillPo();
		bill.setBillCode(billCode);
		bill.setProductName(productName);
		bill.setProductDesc(productDesc);
		bill.setProductUnit(productUnit);
		bill.setProductCount(newProductCount);
		bill.setTotalPrice(newTotalPrice);
		bill.setProviderId(newProviderId);
		bill.setIsPayment(newIsPayment);
		//mybatis去操作数据库 4 数据库操作错误
		SqlSession sqlSession;
		sqlSession = MyBatisUtil.createSqlSession();
		Integer ret;
		try {
			ret = sqlSession.getMapper(BillMapper.class).save(bill);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			MyBatisUtil.closeSqlSession(sqlSession);
			return new Response(4);
		} finally {
			//释放资源
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		//0 操作成功
		return new Response(0).add("ret", ret);
	}

	@Override
	public Response update(String billCode, String productName, String productDesc,
			String productUnit, String productCount, String totalPrice, String isPayment,
			String providerId, String id) {
		//2 传入值含有空值
		if (id == null) {
			return new Response(2);
		}
		Long newId;
		Double newProductCount=null;
		Double newTotalPrice=null;
		Integer newIsPayment=null;
		Long newProviderId=null;
		//3 类型转换错误
		try {
			if (productCount!=null){
				newProductCount = Double.parseDouble(productCount);
			}
			if (totalPrice!=null){
				newTotalPrice = Double.parseDouble(totalPrice);
			}
			if (isPayment!=null){
				newIsPayment = Integer.parseInt(isPayment);
			}
			if (providerId!=null){
				newProviderId = Long.parseLong(providerId);
			}
			newId=Long.parseLong(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(3);
		}
		BillPo bill = new BillPo();
		bill.setId(newId);
		bill.setBillCode(billCode);
		bill.setProductName(productName);
		bill.setProductDesc(productDesc);
		bill.setProductUnit(productUnit);
		bill.setProductCount(newProductCount);
		bill.setTotalPrice(newTotalPrice);
		bill.setProviderId(newProviderId);
		bill.setIsPayment(newIsPayment);
		//mybatis去操作数据库 4 数据库操作错误
		SqlSession sqlSession;
		sqlSession = MyBatisUtil.createSqlSession();
		Integer ret;
		try {
			ret = sqlSession.getMapper(BillMapper.class).update(bill);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			MyBatisUtil.closeSqlSession(sqlSession);
			return new Response(4);
		} finally {
			//释放资源
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		//0 操作成功
		return new Response(0).add("ret", ret);
	}

	@Override
	public Response delete(String id) {
		//2 传入值含有空值
		if (id == null) {
			return new Response(2);
		}
		Long newId;
		//3 类型转换错误
		try {
			newId= Long.parseLong(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(3);
		}
		BillPo bill = new BillPo();
		bill.setId(newId);
		//mybatis去操作数据库 4 数据库操作错误
		SqlSession sqlSession;
		sqlSession = MyBatisUtil.createSqlSession();
		Integer ret;
		try {
			ret = sqlSession.getMapper(BillMapper.class).delete(bill);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			MyBatisUtil.closeSqlSession(sqlSession);
			return new Response(4);
		} finally {
			//释放资源
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		//0 操作成功
		return new Response(0).add("ret", ret);
	}

	@Override
	public Response query(String billCode, String productName, String productDesc,
			String productUnit, String productCount, String totalPrice, String isPayment,
			String providerId,String pageNum,String pageSize) {
		//2 传入值含有空值
		if (pageSize==null||pageNum==null){
			return new Response(2);
		}
		Double newProductCount=null;
		Double newTotalPrice=null;
		Integer newIsPayment=null;
		Long newProviderId=null;
		Integer startIndex;
		Integer count;
		//3 类型转换错误
		try {
			if (productCount!=null){
				newProductCount = Double.parseDouble(productCount);
			}
			if (totalPrice!=null){
				newTotalPrice = Double.parseDouble(totalPrice);
			}
			if (isPayment!=null){
				newIsPayment = Integer.parseInt(isPayment);
			}
			if (providerId!=null){
				newProviderId = Long.parseLong(providerId);
			}
			startIndex=(Integer.parseInt(pageNum)-1)*Integer.parseInt(pageSize);
			count=Integer.parseInt(pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(3);
		}
		BillPo bill = new BillPo();
		bill.setBillCode(billCode);
		bill.setProductName(productName);
		bill.setProductDesc(productDesc);
		bill.setProductUnit(productUnit);
		bill.setProductCount(newProductCount);
		bill.setTotalPrice(newTotalPrice);
		bill.setProviderId(newProviderId);
		bill.setIsPayment(newIsPayment);
		System.out.println(bill);
		//mybatis去操作数据库 4 数据库操作错误
		SqlSession sqlSession;
		sqlSession = MyBatisUtil.createSqlSession();
		List<BillBo> billBos;
		try {
			billBos = sqlSession.getMapper(BillMapper.class).query(bill,startIndex,count);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			MyBatisUtil.closeSqlSession(sqlSession);
			return new Response(4);
		} finally {
			//释放资源
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		//0 操作成功
		return new Response(0).add("bills", billBos);
	}

	@Override
	public Response queryById(String id) {
		//2 传入值含有空值
		if (id == null) {
			return new Response(2);
		}
		Long newId;
		//3 类型转换错误
		try {
			newId= Long.parseLong(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(3);
		}
		BillPo billPo = new BillPo();
		billPo.setId(newId);
		//mybatis去操作数据库 4 数据库操作错误
		SqlSession sqlSession;
		sqlSession = MyBatisUtil.createSqlSession();
		BillBo billBo ;
		try {
			billBo = sqlSession.getMapper(BillMapper.class).query(billPo,0,1).get(0);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			MyBatisUtil.closeSqlSession(sqlSession);
			return new Response(4);
		} finally {
			//释放资源
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		//0 操作成功
		return new Response(0).add("bill", billBo);
	}

	@Override
	public Response count(String billCode, String productName, String productDesc,
			String productUnit, String productCount, String totalPrice, String isPayment,
			String providerId) {
		Double newProductCount=null;
		Double newTotalPrice=null;
		Integer newIsPayment=null;
		Long newProviderId=null;
		//3 类型转换错误
		try {
			if (productCount!=null){
				newProductCount = Double.parseDouble(productCount);
			}
			if (totalPrice!=null){
				newTotalPrice = Double.parseDouble(totalPrice);
			}
			if (isPayment!=null){
				newIsPayment = Integer.parseInt(isPayment);
			}
			if (providerId!=null){
				newProviderId = Long.parseLong(providerId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(3);
		}
		BillPo bill = new BillPo();
		bill.setBillCode(billCode);
		bill.setProductName(productName);
		bill.setProductDesc(productDesc);
		bill.setProductUnit(productUnit);
		bill.setProductCount(newProductCount);
		bill.setTotalPrice(newTotalPrice);
		bill.setProviderId(newProviderId);
		bill.setIsPayment(newIsPayment);
		System.out.println(bill);
		//mybatis去操作数据库 4 数据库操作错误
		SqlSession sqlSession;
		sqlSession = MyBatisUtil.createSqlSession();
		Integer ret ;
		try {
			ret = sqlSession.getMapper(BillMapper.class).count(bill);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			MyBatisUtil.closeSqlSession(sqlSession);
			return new Response(4);
		} finally {
			//释放资源
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		//0 操作成功
		return new Response(0).add("count", ret);
	}
}
