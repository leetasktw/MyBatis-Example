package com.ylforbiz.mapper;

import com.ylforbiz.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderMapper {

    List<Order> selectAll();

    /**
     * 條件查詢第一種方法
     */
    List<Order> selectByCondition(@Param("orderId") String orderId, @Param("productName") String productName);

    /**
     * 條件查詢第二種方法
     */
    List<Order> selectByCondition(Order order);

    /**
     * 條件查詢第三種方法
     */
    List<Order> selectByCondition(Map map);

    void insertOne(Order order);

    int update(Order order);

    /**
     * 單一刪除
     */
    void deleteById(int id);

    /**
     * 批量刪除
     */
    void deleteByIds(@Param("ids") int[] ids);
}
