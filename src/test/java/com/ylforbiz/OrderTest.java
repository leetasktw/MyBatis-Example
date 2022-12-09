package com.ylforbiz;

import com.ylforbiz.mapper.OrderMapper;
import com.ylforbiz.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderTest {

    private SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testSelectAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orders = orderMapper.selectAll();
        System.out.println(orders);
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws IOException {
        String orderId = "2022";
        String productName = "電";
        orderId = "%" + orderId + "%";
        productName = "%" + productName + "%";

        Order order = new Order();
        order.setOrderId(orderId);
        order.setProductName(productName);

        Map map = new HashMap<>();
        map.put("orderId", orderId);
        map.put("productName", productName);

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orders1 = orderMapper.selectByCondition(orderId, productName); // 條件查詢第一種方法
        List<Order> orders2 = orderMapper.selectByCondition(order); // 條件查詢第二種方法
        List<Order> orders3 = orderMapper.selectByCondition(map); // 條件查詢第三種方法
        System.out.println(orders1);
        System.out.println(orders2);
        System.out.println(orders3);
        sqlSession.close();
    }

    @Test
    public void testInsertOne() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = new Order();
        order.setOrderId("20221201120606");
        order.setProductName("喇叭");
        order.setPrice(600);
        order.setCreateTime(new Date());
        orderMapper.insertOne(order);
        System.out.println(order.getId());
        sqlSession.commit(); // 提交事務
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = new Order();
        order.setId(5);
        order.setProductName("螢幕");
        order.setCreateTime(new Date());
        orderMapper.update(order);
        sqlSession.commit(); // 提交事務
        sqlSession.close();
    }

    @Test
    public void testDeleteById() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        orderMapper.deleteById(5);
        sqlSession.commit(); // 提交事務
        sqlSession.close();
    }

    @Test
    public void testDeleteByIds() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        orderMapper.deleteByIds(new int[]{3, 4});
        sqlSession.commit(); // 提交事務
        sqlSession.close();
    }
}
