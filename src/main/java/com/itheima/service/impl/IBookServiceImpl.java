package com.itheima.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IBookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

    @Autowired
    private BookDao bookDao;

//    @Override
//    public boolean saveBook(Book book) {
//        return false;
//    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        //注意分页操作需要使用mybatisplus的分页拦截器，在配置类中配置
        bookDao.selectPage(page,null);
        System.out.println("page="+page);
        return page;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        System.out.println(currentPage+"  "+pageSize+" "+book.toString());
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        lqw.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());
        IPage page = new Page(currentPage,pageSize);
        bookDao.selectPage(page,lqw);
        return page;
    }
}
