package WarehouseSystemManager.common;
import org.springframework.util.DigestUtils;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;


public class MD5Util {
    private static int saltLength = 6;

    public static String md5(String str){
        return DigestUtils.md5DigestAsHex(str.getBytes(StandardCharsets.UTF_8));
    }

    public static String getSalt(){
        return RandomStringUtils.randomAlphanumeric(saltLength);
    }

    public static void main(String[] args) {
        for(int i = 0; i < 3; i++){
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            System.out.println(md5(timestamp.toString()));
        }

    }

}
