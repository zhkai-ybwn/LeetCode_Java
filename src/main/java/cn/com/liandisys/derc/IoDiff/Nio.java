package cn.com.liandisys.derc.IoDiff;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhkai
 * @date 2021年3月22日14:39:49
 */
public class Nio {
    /**
     * NIO 测试方法
     */
    public static void nioTest() {
        //同理对应的还有：ByteBuffer,IntBuffer,FloatBuffer,CharBuffer,ShortBuffer,DoubleBuffer,LongBuffer
        //创建一个Buffer，大小为5
        IntBuffer buffer = IntBuffer.allocate(5);
        // 存放数据
        int size = buffer.capacity();
        for (int i = 0; i < size; i++) {
            buffer.put(i);
        }
        // 切换成读模式，读写切换
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }

    /**
     * 使用FileChannel写入文本文件
     */
    public static void nioFileChannelWrite() throws IOException {
        String writeStr = "Hello, Java菜鸟程序员";
        // 创建一个输出流
        FileOutputStream fileOutputStream = new FileOutputStream("hello.txt");
        // 获取通道
        FileChannel channel = fileOutputStream.getChannel();
        // 创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        // 写入byteBuffer
        byteBuffer.put(writeStr.getBytes());
        // 切换模式
        byteBuffer.flip();
        // 写入通道
        channel.write(byteBuffer);
        // 关闭
        channel.close();
        fileOutputStream.close();
    }

    /**
     * 使用FileChannel 读取文本文件
     */
    public static void nioFileChannelRead() throws IOException{
        FileInputStream fileInputStream = new FileInputStream("hello.txt");
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        channel.read(byteBuffer);
        System.out.println(new String(byteBuffer.array(), 0, byteBuffer.limit()));
        channel.close();
        fileInputStream.close();
    }

    /**
     * 使用FileChannel复制文件
     */
    public static void nioFileChannelCopy() throws IOException{
        FileInputStream fileInputStream = new FileInputStream("hello.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("world.txt");
        FileChannel inChannel = fileInputStream.getChannel();
        FileChannel outChannel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1);
        while (inChannel.read(byteBuffer) != -1){
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            // 清空重置
            byteBuffer.clear();
        }
        fileOutputStream.close();
        fileInputStream.close();
    }

    /**
     * 使用transferFrom复制文件
     */
    public static void nioTransferFromCopy() throws IOException{
        FileInputStream fileInputStream = new FileInputStream("hello.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("world.txt");
        FileChannel inChannel = fileInputStream.getChannel();
        FileChannel outChannel = fileOutputStream.getChannel();
        // 从哪拷贝，从几开始到几结束 对应的还有transferTo()方法
        outChannel.transferFrom(inChannel, 0, inChannel.size());
        outChannel.close();
        fileOutputStream.close();
        fileInputStream.close();
    }
}
