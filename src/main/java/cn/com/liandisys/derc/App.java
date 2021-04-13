package cn.com.liandisys.derc;

import cn.com.liandisys.derc.LeetCode.*;
import org.apache.log4j.Logger;


/**
 * @author zhkai
 * @date 2021年3月22日11:23:08
 */


public class App {
    public static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Test start");
        ReplaceSpace.replaceSpaceTest();
        logger.info("Test end");
    }


}
