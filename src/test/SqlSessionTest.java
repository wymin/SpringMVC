import com.base.dao.UserDao;
import com.base.pojo.User;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Wymin on 2018/6/30 19:57
 */
public class SqlSessionTest {

    private static SqlSessionFactory sqlSessionFactory;

    static{
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("294616741");
        TransactionFactory factory = new JdbcTransactionFactory();
        //创建数据库运行环境
        Environment environment = new Environment("development",factory,dataSource);
        //构建一个Configuration对象
        Configuration configuration = new Configuration(environment);
        //注册一个Mybatis上下文
        configuration.getTypeAliasRegistry().registerAlias("user", User.class);
        //加入一个映射器
        configuration.addMapper(UserDao.class);
        //使用SqlSessionFactoryBuilder构建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    @Test
    public void test(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            List<User> list = userDao.findAllUserNoMaping();
            if(null!=list && list.size()>0){
                System.out.println(Arrays.toString(list.toArray()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null!=sqlSession) {
                sqlSession.close();
            }
        }

    }

}
