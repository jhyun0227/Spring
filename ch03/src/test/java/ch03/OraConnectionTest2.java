package ch03;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/java/db.xml" })
public class OraConnectionTest2 {
	@Inject // Autowired�� ���� ����
	private DataSource ds;
	@Test
	public void testConn() {
		try {
			Connection conn = ds.getConnection();
			System.out.println("���� ����");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}