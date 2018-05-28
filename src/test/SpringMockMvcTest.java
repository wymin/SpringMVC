import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


/**
 * 集成Web环境方式spring单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)//调用Spring单元测试类
@WebAppConfiguration//指定Web资源的位置  默认：src/main/webapp
@ContextConfiguration(locations = {"classpath*:/spring-context.xml","classpath*:/spring-mvc.xml"})//加载spring容器
public class SpringMockMvcTest {

    @Autowired
    private WebApplicationContext application;

    private MockMvc mvc;

    @Before
    public void before(){
        this.mvc = MockMvcBuilders.standaloneSetup(this.application).build();
    }

    @Test
    public void test() throws Exception{
        mvc.perform(post("/login/test")).andDo(print());//执行请求
    }
}
