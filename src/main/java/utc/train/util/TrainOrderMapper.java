package utc.train.util;

import org.springframework.jdbc.core.RowMapper;
import utc.train.pojo.TrainOrder;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Bill
 * @version 2012-02-06
 */
public class TrainOrderMapper implements RowMapper<TrainOrder>{

    @Override
    public TrainOrder mapRow(ResultSet resultSet, int i) throws SQLException {
        TrainOrder t = new TrainOrder();



        return t;
    }

}
