import com.cola.dao.UserDao;
import com.cola.entity.User;
import com.cola.utils.MybatisUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        logger.info("测试，进入getUserLike方法成功！");

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void testLog4j() {
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");
    }

    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> userList = mapper.getUserByLimit(map);

        for(User user:userList){
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //RowBounds实现
        RowBounds rowBounds = new RowBounds(1,2);


        //通过java代码层面实现分页
        List<User> userList = sqlSession.selectList("com.cola.dao.UserDao.getUserByRowBounds",null,rowBounds);

        for(User user:userList){
            System.out.println(user);
        }

        sqlSession.close();
    }
}
