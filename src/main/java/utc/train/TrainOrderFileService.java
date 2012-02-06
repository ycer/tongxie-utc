package utc.train;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.*;

/**
 * @author Bill
 * @version 2012-02-06
 */
@Component
public class TrainOrderFileService {

    static String[] path = {
            "user.home",
            "catalina.home"
    };

    @Resource
    private JdbcTemplate template;

    public void migrateEntries() throws IOException, UnsupportedEncodingException {


    }


}
