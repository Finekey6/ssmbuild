import com.kuang.pojo.Books;
import com.kuang.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class test {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = (BookService) context.getBean("BookServiceImpl");
        for (Books books : bookServiceImpl.queryAllBook()) {
            System.out.println(books);
        }
    }
    @Test
    public void test2(){
        String[] arr = new String[1];
        arr[0] = "";
        String sub = arr[0].substring(0, 0);
//        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);
        System.out.println();
    }
}
