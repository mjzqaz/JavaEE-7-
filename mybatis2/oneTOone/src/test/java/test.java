import edu.gdpu.dao.StudentDao;
import edu.gdpu.pojo.Student;
import edu.gdpu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class test {
    @Test
    public void test01() {
        SqlSession session = MybatisUtil.getSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        mapper.addStudent(new Student(11, "mjz", 18), 1);
    }

    @Test
    public void test02() {
        SqlSession session = MybatisUtil.getSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        System.out.println(mapper.queryStudent1(88));
    }

    @Test
    public void test03() {
        SqlSession session = MybatisUtil.getSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        Student student = mapper.queryStudent2(88);
        System.out.println(student);
    }

}
