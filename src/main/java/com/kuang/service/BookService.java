package com.kuang.service;

import com.kuang.pojo.Books;
import java.util.List;

public interface BookService {
    //增加一本书
    int addBook(Books books);
    //删除一本书
    int deleteBookById(int id);
    //更新一本书
    int updateBook(Books books);
    //查询一本书
    Books queryBookbyId(int id);
    //查询全部书
    List<Books> queryAllBook();
    //根据书名查询书籍信息
    List<Books> queryBookByName(String name);
}
