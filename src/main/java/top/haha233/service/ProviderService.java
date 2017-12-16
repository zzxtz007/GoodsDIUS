package top.haha233.service;

import top.haha233.util.Response;

/**
 * @author Ice_Dog
 */
public interface ProviderService {
	/**
	 * 查询所有的ProviderBo
	 *
	 * @return ProviderBo结果集
	 */
	Response query();

	/**
	 * 根据id 查询ProviderBo
	 *
	 * @param id 必填
	 * @return ProviderBo结果
	 */
	Response queryById(String id);
}
