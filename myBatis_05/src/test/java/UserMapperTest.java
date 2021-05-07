import com.cola.dao.UserDao;
import com.cola.entity.User;
import com.cola.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //底层主要应用反射
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        /*List<User> userList = mapper.getUsers();

        for (User user:userList){
            System.out.println(user);
        }*/

        /*
        User userById = mapper.getUserById(1);
        System.out.println(userById);
         */

//        mapper.addUser(new User(6,"hello","1232"));

//        mapper.updateUser(new User(6,"to","123"));

        mapper.deleteUser(5);
        sqlSession.close();
    }
}
