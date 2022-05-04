package com.hainantravel.lin.service;

import com.hainantravel.lin.dao.NoticeDao;
import com.hainantravel.lin.pojo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Lin
 * @time: 2021/1/10 19:17
 * @Description: mongoDB的service层
 */
@Service
public class NoticeService {
    @Autowired
    NoticeDao noticeDao;

    public Notice addNotice(Notice notice) {
        return noticeDao.addNotice(notice);
    }

    public List<Notice> findAllByPage(Integer page, Integer pageSize) {
        int start = (page - 1) * pageSize;
        return noticeDao.findAllByPage(start, pageSize);
    }

    public  List<Notice> queryNotice(String queryText){
        return noticeDao.queryNotice(queryText);
    }

    public List<Notice> findAll() {
        return noticeDao.findAll();
    }

    //查询总数
    public long queryTotal() {
        return noticeDao.queryTotal();
    }

}
