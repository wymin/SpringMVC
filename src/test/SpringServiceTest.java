import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Wymin on 2018/6/30 19:18
 */
@RunWith(SpringJUnit4ClassRunner.class)//调用Spring单元测试类
@WebAppConfiguration//指定Web资源的位置  默认：src/main/webapp
@ContextConfiguration(locations = {"classpath*:/spring-context.xml"})//加载spring容器
public class SpringServiceTest {

    @Autowired
    private WebApplicationContext application;

    @Before
    public void before(){
        try{

            System.out.println(application.getServletContext().getContextPath());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        System.out.println(application.getServletContext().getContextPath());
    }

}
