import edu.gdpu.dao.StudentMapper;
import edu.gdpu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class test {
    @Test
    public void test01() {
        SqlSession session = MybatisUtil.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        System.out.println(mapper.queryStudentById(88));
    }

}