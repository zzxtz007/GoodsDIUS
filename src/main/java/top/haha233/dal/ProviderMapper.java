package top.haha233.dal;

import org.apache.ibatis.annotations.Param;
import top.haha233.model.bo.ProviderBo;
import top.haha233.model.po.ProviderPo;

import java.util.List;

/**
 * @author Ice_Dog
 */
public interface ProviderMapper {

	/**
	 * 增加方法
	 * @param providerPo 供应商模型
	 * @return 处理状态码
	 */
	int save(@Param("providerPo") ProviderPo providerPo);

	/** 删除方法
	 * @param providerPo 供应商模型
	 * @return 处理状态码
	 */
	int delete(@Param("providerPo") ProviderPo providerPo);

	/** 修改方法
	 * @param providerPo 供应商模型
	 * @return 处理状态码
	 */
	int update(@Param("providerPo")ProviderPo providerPo);

	/** 查询方法
	 * @param providerPo 供应商模型
	 * @return 供应商bo模型
	 */
	List<ProviderBo> query(@Param("providerPo")ProviderPo providerPo);
}
