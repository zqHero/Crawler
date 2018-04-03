package com.shizongger.main;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.shizongger.domain.MyIp;


/***
 *  һ��  ������  ��ҳ΢�� ΢�����ݵ�С����
 * author:zhaoq
 * github:https://github.com/zqHero
 * csdn:http://blog.csdn.net/u013233097
 * 2018��3��26��
 */
public class Main {
	private static Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		 try {
	            //1.��ip�����ַ����get�����õ������ip
	            Document doc = Jsoup.connect("http://guba.eastmoney.com/")
	                    .userAgent("Mozilla")
	                    .cookie("auth", "token")
	                    .timeout(3000)
	                    .get();

	            
	            
	            //ƥ��������ʽ��
	            Pattern pattern = Pattern.compile("^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$");
	            Matcher matcher = pattern.matcher(doc.toString());

	            ArrayList<String> ips = new ArrayList<String>();
	           
	            if (!matcher.find()) {
	            	 System.out.println("δ��ѯ������");
				}else{
					 while (matcher.find()) {
			                System.out.println(matcher.group());
			            }
				}
	            
	        } catch (IOException e) {
	        	System.out.println("-======�����쳣====" + e.toString() );
	        }
	}

	
}






