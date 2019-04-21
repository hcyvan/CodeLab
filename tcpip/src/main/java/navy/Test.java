package navy;
import java.util.List;
import java.lang.System;

import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.core.Pcaps;

public class Test {
    public static void main(String[] arg)throws Exception{
        System.out.println(System.getProperty("my.test"));
        System.setProperty("my.test", "change");
        System.out.println(System.getProperty("my.test"));
        List<PcapNetworkInterface> inters=Pcaps.findAllDevs();
    }
}
