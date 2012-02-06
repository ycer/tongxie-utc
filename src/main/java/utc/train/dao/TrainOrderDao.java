package utc.train.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import utc.train.pojo.TrainOrder;

import javax.annotation.Resource;
import java.sql.Types;

/**
 * @author Bill
 * @version 2012-02-06
 */
@Repository
public class TrainOrderDao {

    @Resource
    private JdbcTemplate template;

    public void saveTrainOrderEntry(TrainOrder trainOrder) {
        template.update("insert into trainorder(train_id, train_type, station_no, station, day, a_time, d_time, distance, p1,p2,p3,p4) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new Object[]{
                    trainOrder.getTrainId(),
                    trainOrder.getTrainType(),
                    trainOrder.getStationNo(),
                    trainOrder.getStation(),
                    trainOrder.getDay(),
                    trainOrder.getArriveTime(),
                    trainOrder.getDepartureTime(),
                    trainOrder.getDistance(),
                    trainOrder.getP1(),
                    trainOrder.getP2(),
                    trainOrder.getP3(),
                    trainOrder.getP4()
                },
                new int[] {
                    Types.VARCHAR,
                    Types.VARCHAR,
                    Types.INTEGER,
                    Types.VARCHAR,
                    Types.INTEGER,
                    Types.VARCHAR,

                    Types.VARCHAR,
                    Types.INTEGER,
                    Types.INTEGER,
                    Types.INTEGER,
                    Types.INTEGER,
                    Types.INTEGER
                }
//                new Class[] {
//                    String.class,
//                    String.class,

//                    int.class,
//                    String.class,
//                    int.class,
//                    String.class,

//                    String.class,
//                    int.class,
//                    int.class,
//                    int.class,
//                    int.class,
//                    int.class
//                }
        );
    }

//    public void

}
