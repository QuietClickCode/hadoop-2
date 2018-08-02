package hadoop;

import org.apache.hadoop.fs.FileStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.hadoop.fs.FsShell;

/**
 * @author alan.huang
 */
@SpringBootApplication
public class SpringBootHDFSApp implements CommandLineRunner {

    /**
     * 用于执行hdfs shell命令的对象
     */
    @Autowired
    private FsShell shell;

    @Override
    public void run(String... args) {
        for (FileStatus s : shell.lsr("/")) {
            System.out.println("> " + s.getPath());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHDFSApp.class, args);
    }
}