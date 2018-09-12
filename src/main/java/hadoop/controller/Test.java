package hadoop.controller;

import org.apache.hadoop.fs.FileStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.fs.FsShell;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alan.huang
 */
@RestController
@RequestMapping("/api")
public class Test {

    @Autowired
    private FsShell shell;

    @GetMapping("/test")
    private void test() {
        for (FileStatus s : shell.lsr("/")) {
            System.out.println("> " + s.getPath());
        }
//        shell.put("E:/MiFlashvcom.ini","/user/input/");
    }
}
