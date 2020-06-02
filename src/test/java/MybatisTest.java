import com.dao.IPersonDao;
import com.domain.Person;
import com.mybatis.io.Resources;
import com.mybatis.sqlsession.SqlSession;
import com.mybatis.sqlsession.SqlSessionFactory;
import com.mybatis.sqlsession.SqlSessionFactoryBuilder;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws IOException, SQLException {
        /**
         * 测试查询
         * @throws IOException
         */
            // 加载配置文件
            InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
            // 创建SqlSessionFactory
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            // 创建SqlSession对象
            SqlSession session = factory.openSession();
            // 获取到代理对象
            IPersonDao personDao = session.getMapper(IPersonDao.class);
            //System.out.println("personDao:");
            // 查询所有
            List<Person> list = personDao.findAll();
            for(Person person:list){
                System.out.println(person);
            }
            session.close();
            in.close();

        }

}
