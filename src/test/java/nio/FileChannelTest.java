package nio;

import nio.fileChannel.FileChannel01;
import org.junit.Test;

public class FileChannelTest {

    @Test
    public void bufTest01() {
        FileChannel01 fileChannel = new FileChannel01();
        fileChannel.buffer01();
    }

    @Test
    public void transferToTest() {
        FileChannel01 fileChannel = new FileChannel01();
        fileChannel.transferTo();
    }
}
