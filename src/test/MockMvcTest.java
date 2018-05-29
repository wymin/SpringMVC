import com.base.controller.DemoController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * SpringMVC独立测试（需指定控制器）
 */
public class MockMvcTest {

    //需要测试的控制器
    @InjectMocks
    private DemoController demoController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(demoController).build();//构造MockMvc
    }

    @Test
    public void test() throws Exception{
        mockMvc.perform(post("/test")).andDo(print());
    }
}
