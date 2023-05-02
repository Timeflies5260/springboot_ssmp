package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.Book;

//通过继承IService类，基础的增删改查就不用自己写代码了，也可以在通用接口上做重载和追加新功能
// 注意重载尽量不要覆盖原始操作，避免原始提供的功能丢失，比如save()方法，你可以写saveBook()
public interface IBookService extends IService<Book> {
//    boolean saveBook(Book book);
    IPage<Book> getPage(int currentPage, int pageSize);

    IPage<Book> getPage(int currentPage, int pageSize, Book book);

}
