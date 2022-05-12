package pers.shui.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.shui.ssm.pojo.Books;
import pers.shui.ssm.service.BookService;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部图书
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }
}
