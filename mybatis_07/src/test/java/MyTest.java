import com.cola.dao.TeacherMapper;
import com.cola.entity.Student;
import com.cola.entity.Teacher;
import com.cola.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher = mapper.getTeacher1(1);

        for(Student s:teacher.getStudents()){
            System.out.println(s);
        }


        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher = mapper.getTeacher2(1);

        for(Student s:teacher.getStudents()){
            System.out.println(s);
        }


        sqlSession.close();
    }
}
