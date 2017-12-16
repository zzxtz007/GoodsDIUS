package top.haha233.service;

import top.haha233.util.Response;

/**
 * @author Ice_Dog
 */
public interface BillService {
	/**
	 * 从serlvet接收参数封装成PillPO模型
	 * 传入dal层进行持久化操作
	 *
	 * @param billCode     必填
	 * @param productName  必填
	 * @param productDesc  必填
	 * @param productUnit  必填
	 * @param productCount 必填
	 * @param totalPrice   必填
	 * @param isPayment    必填
	 * @param providerId   必填
	 * @return 返回 Response
	 */
	Response add(String billCode, String productName, String productDesc, String productUnit,
			String productCount, String totalPrice, String isPayment, String providerId);


	/**
	 * 从serlvet接收参数封装成PillPO模型
	 * 传入dal层进行持久化操作
	 *
	 * @param billCode     选填
	 * @param productName  选填
	 * @param productDesc  选填
	 * @param productUnit  选填
	 * @param productCount 选填
	 * @param totalPrice   选填
	 * @param isPayment    选填
	 * @param providerId   选填
	 * @param id           必填
	 * @return 返回 Response
	 */
	Response update(String billCode, String productName, String productDesc, String productUnit,
			String productCount, String totalPrice, String isPayment, String providerId, String id);


	/**
	 * 从serlvet接收参数封装成PillPO模型
	 * 传入dal层进行持久化操作
	 *
	 * @param id 必填
	 * @return 返回 Response
	 */
	Response delete(String id);

	/**
	 * 从serlvet接收参数封装成PillPO模型
	 * 传入dal层进行查询操作
	 *
	 * @param billCode     选填
	 * @param productName  选填
	 * @param productDesc  选填
	 * @param productUnit  选填
	 * @param productCount 选填
	 * @param totalPrice   选填
	 * @param isPayment    选填
	 * @param providerId   选填
	 * @param pageSize     必填
	 * @param pageNum      必填
	 * @return 返回 Response
	 */
	Response query(String billCode, String productName, String productDesc, String productUnit,
			String productCount, String totalPrice, String isPayment, String providerId,
			String pageNum,String pageSize);

	/**
	 * 从serlvet接收参数封装成PillPO模型
	 * 传入dal层进行查询操作
	 *
	 * @param id 必填
	 * @return 返回 Response
	 */
	Response queryById(String id);

	/**
	 * 从serlvet接收参数封装成PillPO模型
	 * 传入dal层进行查询操作
	 *
	 * @param billCode     选填
	 * @param productName  选填
	 * @param productDesc  选填
	 * @param productUnit  选填
	 * @param productCount 选填
	 * @param totalPrice   选填
	 * @param isPayment    选填
	 * @param providerId   选填
	 * @return 查询到的条目数
	 */
	Response count(String billCode, String productName, String productDesc, String productUnit,
			String productCount, String totalPrice, String isPayment, String providerId);
}
