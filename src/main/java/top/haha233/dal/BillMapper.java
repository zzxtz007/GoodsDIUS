package top.haha233.dal;

import org.apache.ibatis.annotations.Param;
import top.haha233.model.bo.BillBo;
import top.haha233.model.po.BillPo;

import java.util.List;

/**
 * @author Ice_Dog
 */
public interface BillMapper {
	/**
	 * 增加方法
	 * @param billPo 供应商模型
	 * @return 处理状态码
	 */
	int save(@Param("billPo") BillPo billPo);

	/** 删除方法
	 * @param billPo 供应商模型
	 * @return 处理状态码
	 */
	int delete(@Param("billPo") BillPo billPo);

	/** 修改方法
	 * @param billPo 供应商模型
	 * @return 处理状态码
	 */
	int update(@Param("billPo") BillPo billPo);

	/** 查询方法
	 * @param billPo 供应商模型
	 * @return 供应商bo模型
	 */
	List<BillBo> query(@Param("billPo") BillPo billPo,@Param("startIndex") int startIndex,@Param("count") int count);

	/**
	 * 查询方法
	 * @param billPo 供应商模型
	 * @return 查询到的数目
	 */
	int count(@Param("billPo") BillPo billPo);
}
