package samp13;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
// @�پ� �ִ� ���� annotation
// @Component // ��ü(Component)�� ����� ��
@Repository("pd2")
public class ProductDaoImpl2 implements ProductDao {
	public Product getProduct(String name) {
		return new Product(name, 5000);
	}

}
