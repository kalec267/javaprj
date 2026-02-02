package d260202_02;

import java.util.List;

public interface AccountbookDAO {
	List<Accountbook> findByCategory(String category);

}
