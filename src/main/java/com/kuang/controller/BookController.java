package com.kuang.controller;

import com.kuang.pojo.Books;
import com.kuang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller调用service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部的书籍，并返回一个书籍展示界面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }

    //跳转到添加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }

    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBooks=>"+books);
        bookService.addBook(books);
        return "redirect:/book/allBook";//重定向可以防止表单重复提交
    }

    //跳转到修改书籍信息页面
    @RequestMapping("/toUpdate")
    public String toUpdatePaper(int id,Model model){
        Books book = bookService.queryBookbyId(id);
        model.addAttribute("QBook",book);
        return "updateBook";
    }

    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook=>"+books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    //删除书籍信息
    @RequestMapping("/toDelete/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){
        int i = bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    //根据书名查询书籍信息
    @RequestMapping("/queryBook")
    public String queryBookByName(String queryBookName,Model model){
        List<Books> list = bookService.queryBookByName(queryBookName);
        System.err.println(list);
        if (list.size() == 0){
            model.addAttribute("error","未查到相关信息！");
        }
        model.addAttribute("list",list);
        return "allBook";
    }
}
