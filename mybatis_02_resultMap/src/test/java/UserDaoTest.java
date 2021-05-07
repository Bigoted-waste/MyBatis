import com.cola.dao.UserDao;
import com.cola.entity.User;
import com.cola.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

}
