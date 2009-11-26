package oracle.jdbc;

import java.sql.SQLException;

public interface OraclePreparedStatement {

	void setExecuteBatch(int i) throws SQLException;
	int sendBatch();

}
