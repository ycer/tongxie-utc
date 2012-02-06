package utc.train;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import utc.train.dao.DemoDao;
import utc.train.dao.TrainOrderDao;
import utc.train.pojo.TrainOrder;

import javax.annotation.Resource;
import java.io.*;

/**
 * @author Bill
 * @version 2012-02-06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TrainOrderFileServiceTest {

    @Resource
    private DemoDao demoDao;

    @Resource
    private TrainOrderDao trainOrderDao;

    @org.junit.Test
    @Ignore
    public void testReader() throws Exception {

        String filePath = "C:\\Users\\Bill\\Documents\\Train120101.txt";
        File file = new File(filePath);

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "gbk"), 10 * 1024 * 1024);

        String line = null;

        long idx = 0;

        // "T238/T235","新空特快",8,"天津",2,1899/12/30 7:04:00,1899/12/30 7:12:00,1235,154,272,,429
        
        while ((line = reader.readLine()) != null) {

            if (idx++ == 0) {
                continue;
            }

            if (idx % 20 == 0) {
                System.out.println("----------------------");
            }

            System.out.println(idx + " line = " + line);

            String[] fileds = (line + ",000").split(",");

            TrainOrder trainOrder = new TrainOrder();
            trainOrder.setTrainId(fileds[0].replaceAll("\"", ""));
            trainOrder.setTrainType(fileds[1].replaceAll("\"", ""));
            trainOrder.setStationNo(Integer.valueOf(fileds[2]));
            trainOrder.setStation(fileds[3].replaceAll("\"", ""));
            trainOrder.setDay(Integer.valueOf(fileds[4]));
            trainOrder.setArriveTime(getTime(fileds[5]));
            trainOrder.setDepartureTime(getTime(fileds[6]));
            trainOrder.setDistance(Integer.valueOf(fileds[7]));

            trainOrder.setP1(parseInt(fileds[8]));
            trainOrder.setP2(parseInt(fileds[9]));
            trainOrder.setP3(parseInt(fileds[10]));
            trainOrder.setP4(parseInt(fileds[11]));

            trainOrderDao.saveTrainOrderEntry(trainOrder);
        }
    }

    public String getTime(String t) {
        if (t == null || t.length() == 0) return null;
        return t.replaceAll("^.*?(\\d\\d:\\d\\d).*$", "$1");
    }
    
    public Integer parseInt(String s){
        if (s == null || s.length() == 0) {
            return null;
        } else {
            return Integer.parseInt(s);
        }
    }

    @Test
    @Ignore
    public void testMe() {
        String time = "1899/12/30 10:22:00";
        System.out.println("getTime(time) = " + getTime(time));
    }

    @Test
    @Ignore
    public void testArray() throws Exception {
        String[] ss = "\"1461\",\"新空普快\",8,\"东光\",1,1899/12/30 15:46:00,1899/12/30 15:50:00,323,45,96,,,000".split(",");
        System.out.println("ss.length = " + ss.length);
    }
}
