package samp13;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
// @붙어 있는 것이 annotation
// @Component // 객체(Component)로 만들어 줘
@Repository("pd2")
public class ProductDaoImpl2 implements ProductDao {
	public Product getProduct(String name) {
		return new Product(name, 5000);
	}

}
