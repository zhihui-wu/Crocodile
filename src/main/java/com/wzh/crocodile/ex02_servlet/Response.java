package com.wzh.crocodile.ex02_servlet;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.*;
import java.util.Locale;

/**
 * @Description: Http响应
 * @Author: 吴智慧
 * @Date: 2019/11/8 13:36
 */
public class Response implements ServletResponse {

    /**
     * 一次读取信息的容量
     */
    private static final int BUFFER_SIZE = 1024;

    /**
     * http请求
     */
    private Request request;

    /**
     * 从socket对象中获取的，用于创建Response对象，输出HTTP响应的结果
     */
    private OutputStream output;

    private PrintWriter writer;

    public Response(OutputStream output){
        this.output = output;
    }

    public void setRequest(Request request){
        this.request = request;
    }

    /**
     * 发送一个静态资源到浏览器，如html文件
     */
    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {
            // 打开文件
            File file = new File(Constants.WEB_ROOT, request.getUri());
            // 读取文件，写入Response响应的结果
            fis = new FileInputStream(file);
            int ch = fis.read(bytes, 0, BUFFER_SIZE);
            while (ch != -1){
                output.write(bytes, 0, ch);
                ch = fis.read(bytes, 0, BUFFER_SIZE);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // 文件不存在，将错误信息，写入Response响应的结果
            String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
                    "Content-Type: test/html\r\n" +
                    "Content-Length: 23\r\n" +
                    "\r\n" +
                    "<h1>File Not Found</h1>";
            output.write(errorMessage.getBytes());
        }finally {
            if (fis != null){
                fis.close();
            }
        }
    }

    @Override
    public String getCharacterEncoding() {
        return null;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return null;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        // autoFlush设为true，调用println()会自动刷新输出，调用print()不会
        // 因此，如果servlet的service()方法的最后一行调用print()，则该输出内容不会被发送给浏览器
        this.writer = new PrintWriter(output, true);
        return writer;
    }

    @Override
    public void setCharacterEncoding(String charset) {

    }

    @Override
    public void setContentLength(int len) {

    }

    @Override
    public void setContentLengthLong(long len) {

    }

    @Override
    public void setContentType(String type) {

    }

    @Override
    public void setBufferSize(int size) {

    }

    @Override
    public int getBufferSize() {
        return 0;
    }

    @Override
    public void flushBuffer() throws IOException {

    }

    @Override
    public void resetBuffer() {

    }

    @Override
    public boolean isCommitted() {
        return false;
    }

    @Override
    public void reset() {

    }

    @Override
    public void setLocale(Locale loc) {

    }

    @Override
    public Locale getLocale() {
        return null;
    }
}
