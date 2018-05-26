package org.main.redrock.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * 文件读取操作
 * @author liuns
 * @data 2015-8-12 下午03:06:37
 * @version V1.0
 */
public class FileReader {

	/**
	 * 字符流：读取文本数据(如.txt文件)
	 * @param fileName
	 * 		文件路径+文件名
	 * @return String
	 * 		读取的数据
	 */
	public static String readFileByChars(String fileName){
		File file = new File(fileName);
		StringBuffer strbuf = new StringBuffer();
		String str = "";
		BufferedReader read = null;
		try {
			if(file.exists()){
				System.out.println("文件已存在........");
				read = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"utf-8"));
				while((str = read.readLine()) != null){
					strbuf.append(str).append("\r\n");
				}
			}else{
				if(file.createNewFile()){
					System.out.println("文件创建成功........");
				}else{
					System.out.println("文件创建失败........");
				}
			}
			System.out.println("读取文本文件成功........");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(read != null){
				try {
					read.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return strbuf.toString();
	}
	/**
	 * 字节流：读取图片、声音等文件，并另存
	 * @param readFileName
	 *			需要读取的文件（路径+文件名）
	 * @param writeFileName
	 * 			需要存入的文件（路径+文件名）
	 * @return void
	 */
	public static void readFileByBytes(String readFileName, String writeFileName){
		File file = new File(readFileName);
		InputStream in = null;
		OutputStream out = null;
		try {
			if(file.exists()){
				System.out.println("文件存在........");
				byte[] bytes = new byte[10]; 
				in = new FileInputStream(file);
				out = new FileOutputStream(new File(writeFileName));
				int byteread = 0;
				while((byteread = in.read(bytes)) != -1){
					out.write(bytes, 0 ,byteread);
				}
			}else{
				if(file.createNewFile()){
					System.out.println("文件创建成功........");
				}else{
					System.out.println("文件创建失败........");
				}
			}
			System.out.println("读取二进制文件操作成功........");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 显示当前输入流中还剩多少字节数
	 * @param inputStream
	 *			输入流
	 * @return void
	 */
	public static void showAvailableBytes(InputStream inputStream){
		try {
			System.out.println("当前输入流中的字节数：" + inputStream.available());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//测试
	public static void main(String[] args) {
		System.out.println("文件内容：" + FileReader.readFileByChars("F:你好啊.txt"));
		FileReader.readFileByBytes("F:/IO流详解.docx", "F:我晓得蛮.docx");
	}
}
