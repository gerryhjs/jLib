package webSpider;

import org.junit.Test;
import webSpider.SpiderWebsite;

public class Example {
    @Test
    public void spider()
    {
        String SeedUrl="https://blog.csdn.net/effective_coder/article/details/8736718";
        SpiderWebsite w=new SpiderWebsite();
        w.addKey("算法");
        w.extractLinks(SeedUrl,1000);
    }


}
