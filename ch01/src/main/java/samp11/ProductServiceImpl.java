package samp11;

public class ProductServiceImpl implements ProductService{
	private ProductDao pd;
	// �������Ͽ��� ProductDao ��ü�� �����ؼ� �Ű������� �־���(����)
	public void setPd(ProductDao pd) {
		this.pd = pd;
	}

	public Product getProduct() {
		return pd.getProduct("���");
	}
}
