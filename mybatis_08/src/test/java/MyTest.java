import com.cola.dao.BlogMapper;
import com.cola.entity.Blog;
import com.cola.utils.IdUtil;
import com.cola.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog(
                IdUtil.getId(),
                "Mybatis如此简单",
                "cola",
                new Date(),
                9999
        );
        mapper.addBlog(blog);

        blog.setId(IdUtil.getId());
        blog.setTitle("java如此简单");
        mapper.addBlog(blog);

        blog.setId(IdUtil.getId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IdUtil.getId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void queryBlogIf(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
//        map.put("title","java如此简单3");
        map.put("author","cola1");
        map.put("id","1c7fb2ea0f83454f81ce8c2c5c940898");
        List<Blog> blogs = mapper.queryBlogIf(map);
        for (Blog blog:blogs){
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();

        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        map.put("ids",ids);

        List<Blog> blogs = mapper.queryBlogForeach(map);

        for (Blog b:blogs){
            System.out.println(b);
        }


        sqlSession.close();
    }
}
