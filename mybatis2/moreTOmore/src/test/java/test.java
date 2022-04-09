import edu.gdpu.dao.CourseMapper;
import edu.gdpu.dao.StudentMapper;
import edu.gdpu.pojo.Student;
import edu.gdpu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class test {
    @Test
    public void test01(){
        SqlSession session = MybatisUtil.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = mapper.queryStudentById(88);
        System.out.println(student.toString());
    }
    @Test
    public void test02(){
        SqlSession session = MybatisUtil.getSession();
        CourseMapper mapper = session.getMapper(CourseMapper.class);
        System.out.println(mapper.queryCourseByName("高等数学"));

    }
}
