package nio.fileChannel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannel01 {

    /**
     * ByteBuffer
     */
    public void buffer01() {
        String director = "F:\\架构师\\第一阶段\\04.基于Netty的RPC架构实战演练【更多分享关注QQ群233479383】\\1、第一课NIO【更多分享关注微信公众号：Java技术栈】\\1、第一课NIO\\nio笔记.txt";
        try {
            RandomAccessFile aFile = new RandomAccessFile(director,"rw");
            FileChannel inChannel = aFile.getChannel();
            //create buffer with capacity of 1024 bytes
            ByteBuffer buf = ByteBuffer.allocate(1024);
            //read into buffer.
            int bytesRead = inChannel.read(buf);
            while (bytesRead != -1) {
                System.out.println("Read " + bytesRead);
                //make buffer ready for read
                buf.flip();
                while (buf.hasRemaining()) {
                    // read 1 byte at a time
                    System.out.println((char) buf.get());
                }
                //make buffer ready for writing
                buf.clear();
                bytesRead = inChannel.read(buf);
            }
            aFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * FileChannel.transferFrom
     */
    public void transferTo() {
        RandomAccessFile fromFile = null;
        try {
            String fromDirector = "F:\\架构师\\第一阶段\\04.基于Netty的RPC架构实战演练【更多分享关注QQ群233479383】\\1、第一课NIO【更多分享关注微信公众号：Java技术栈】\\1、第一课NIO\\nio笔记.txt";
            String toDirector = "F:\\架构师\\第一阶段\\04.基于Netty的RPC架构实战演练【更多分享关注QQ群233479383】\\1、第一课NIO【更多分享关注微信公众号：Java技术栈】\\1、第一课NIO\\toFile.txt";
            fromFile = new RandomAccessFile(fromDirector, "rw");
            FileChannel      fromChannel = fromFile.getChannel();
            RandomAccessFile toFile = new RandomAccessFile(toDirector, "rw");
            FileChannel      toChannel = toFile.getChannel();
            long position = 0;
            long count = fromChannel.size();
            toChannel.transferFrom(fromChannel,position, count);
//            fromChannel.transferTo(position,count,toChannel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
