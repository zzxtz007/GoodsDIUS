package top.haha233.service.impl;

import org.apache.ibatis.session.SqlSession;
import top.haha233.dal.ProviderMapper;
import top.haha233.model.bo.ProviderBo;
import top.haha233.model.po.ProviderPo;
import top.haha233.service.ProviderService;
import top.haha233.util.Response;
import top.haha233.utils.MyBatisUtil;

import java.util.List;

/**
 * @author Ice_Dog
 */
public class ProviderServiceImpl implements ProviderService {
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
	public Response query() {
		ProviderPo providerPo = new ProviderPo();
		//mybatis去操作数据库 4 数据库操作错误
		SqlSession sqlSession;
		sqlSession = MyBatisUtil.createSqlSession();
		List<ProviderBo> providerBos;
		try {
			providerBos = sqlSession.getMapper(ProviderMapper.class).query(providerPo);
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
		return new Response(0).add("providers", providerBos);
	}

	@Override
	public Response queryById(String id) {
		//2 传入值含有空值
		if (id==null){
			return new Response(2);
		}
		ProviderPo providerPo = new ProviderPo();
		//3 类型转换错误
		try {
			providerPo.setId(Long.parseLong(id));
		}catch (Exception e){
			return new Response(3);
		}
		//mybatis去操作数据库 4 数据库操作错误
		SqlSession sqlSession;
		sqlSession = MyBatisUtil.createSqlSession();
		ProviderBo providerBo;
		try {
			providerBo = sqlSession.getMapper(ProviderMapper.class).query(providerPo).get(0);
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
		return new Response(0).add("provider", providerBo);
	}
}
