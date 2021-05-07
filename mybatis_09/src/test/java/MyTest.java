import com.cola.dao.UserMapper;
import com.cola.pojo.User;
import com.cola.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void queryUserById(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);
        System.out.println("========================");

//        mapper.updateUser(new User(1,"aaa","124"));

        sqlSession.clearCache();

        System.out.println("========================");

        User user2 = mapper.queryUserById(1);
        System.out.println(user2);

        System.out.println(user==user2);

        sqlSession.close();
    }

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        SqlSession sqlSession1 = MybatisUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        sqlSession.close();

        System.out.println("===================================");


        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = mapper1.queryUserById(1);
        System.out.println(user1);

        System.out.println(user == user1);

        sqlSession1.close();
    }
}
