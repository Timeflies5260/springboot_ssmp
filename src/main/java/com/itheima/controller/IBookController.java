package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utils.ReturnedDataByFormat;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

//相比与IBookController2，这里统一了数据返回格式，且增加了返回成功与否的flag
@RestController
@RequestMapping("/books")
public class IBookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public ReturnedDataByFormat getAll(){
        return new ReturnedDataByFormat(true, bookService.list());
    }

    @PostMapping
    public ReturnedDataByFormat save(@RequestBody Book book) throws IOException {
//        R r = new R();
//        boolean flag = bookService.save(book);
//        r.setFlag(flag);
        if (book.getName().equals("123") ) throw new IOException();
        boolean flag = bookService.save(book);
        return new ReturnedDataByFormat(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    public ReturnedDataByFormat update(@RequestBody Book book) throws IOException {
        if (book.getName().equals("123") ) throw new IOException();
        boolean flag = bookService.updateById(book);
        return new ReturnedDataByFormat(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @DeleteMapping("{id}")
    public ReturnedDataByFormat delete(@PathVariable Integer id){
        return new ReturnedDataByFormat(bookService.removeById(id));
    }

    @GetMapping("{id}")
    public ReturnedDataByFormat getById(@PathVariable Integer id){
        return new ReturnedDataByFormat(true, bookService.getById(id));
    }

//    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize){
//        IPage<Book> page = bookService.getPage(currentPage, pageSize);
//        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
//        if( currentPage > page.getPages()){
//            page = bookService.getPage((int)page.getPages(), pageSize);
//        }
//        return new ReturnedDataByFormat(true, page);
//    }

    @GetMapping("{currentPage}/{pageSize}")
    public ReturnedDataByFormat getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book){
//        System.out.println("参数==>"+book);

        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if( currentPage > page.getPages()){
            page = bookService.getPage((int)page.getPages(), pageSize,book);
        }
        return new ReturnedDataByFormat(true, page);
    }

}

















