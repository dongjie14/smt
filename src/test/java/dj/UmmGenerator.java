package dj;

import org.mybatis.generator.api.ShellRunner;

/**
 * Created by dong_jie on 2018-07-21.
 */
public class UmmGenerator {
    public static void main(String[] args) {
        args = new String[] { "-configfile", "src\\test\\resources\\umm-generator-config.xml", "-overwrite" };
        ShellRunner.main(args);
    }
}
