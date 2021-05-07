import com.cola.dao.UserDao;
import com.cola.entity.User;
import com.cola.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {
    @Test
    public void test() {
        //第一步:获取SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        try {
            //方式一： 第二步：执行SQL
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            List<User> userList = userDao.getUserList();
            //方式二：
//        List<User> userList= sqlSession.selectList("com.cola.dao.UserDao.getUserList");

            for (User user : userList) {
                System.out.println(user.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //第三步:关闭SqlSession
            sqlSession.close();
        }

    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    //增删改需要提交事物
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int result = mapper.addUser(new User(3, "xxx", "123"));
        if(result > 0) {
            System.out.println("插入成功！");
        }
        //提交事物
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);

        int res = mapper.updateUser(new User(3, "ppp", "1234"));

        if(res > 0) {
            System.out.println("更新成功！");
        }
        //提交事物
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int res = mapper.deleteUser(3);
        if(res > 0) {
            System.out.println("删除成功！");
        }
        //提交事物
        sqlSession.commit();
        sqlSession.close();
    }

}
