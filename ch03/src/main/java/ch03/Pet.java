package ch03;

import java.util.Date;
import lombok.Data;

//@Getter  // getter method�ڵ� ����
//@Setter  // setter   "
@Data
public class Pet {
	private int petId;
	private String petName;
	private String ownerName;
	private int price;
	private Date birthDate;
}