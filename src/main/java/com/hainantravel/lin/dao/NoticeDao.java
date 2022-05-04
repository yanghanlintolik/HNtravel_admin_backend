package com.hainantravel.lin.dao;

import com.hainantravel.lin.pojo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: Lin
 * @time: 2021/1/10 19:55
 * @Description: mongoDB的DAO层不是接口而是类，并且无需调用Mapper对应的xml执行SQL语句，直接通过
 *               mongoTemplate进行查询即可
 */
@Repository
public class NoticeDao {
    @Autowired
    MongoTemplate mongoTemplate;

    public NoticeDao(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    //保存一条通知
    public Notice addNotice(Notice notice) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date createDate = new Date();
        notice.setCreateDate(sdf.format(createDate));
        return mongoTemplate.save(notice);
    }

    //查询所有通知
    public List<Notice> findAll() {
        return mongoTemplate.findAll(Notice.class);
    }

    //分页查询通知
    public List<Notice> findAllByPage(Integer page, Integer pageSize) {
        Query query = new Query();
        query.skip(page).limit(pageSize);
        return mongoTemplate.find(query, Notice.class);
    }

    //搜索通知
    public List<Notice> queryNotice(String queryText){
        Criteria criteria=new Criteria("title");//搜索条目
        criteria.regex(queryText);//条目匹配属性
        Query query = new Query(criteria);
        return mongoTemplate.find(query,Notice.class);
    }

    //查询总数
    public long queryTotal() {
        Query query = new Query();
        long total = mongoTemplate.count(query,Notice.class);
        return total;
    }
}
