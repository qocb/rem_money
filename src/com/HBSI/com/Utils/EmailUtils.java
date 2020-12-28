package com.HBSI.com.Utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;


public class EmailUtils {
	//自己的邮箱
    public static String sendEmailAccount ="sunyutong20010820@163.com";
    //邮箱授权码
    public static String sendEmailPwd="BRMUMMNCZRZPUZEK";
    
    /**
     * 发送简单邮箱方法
     * @param sendMail :发送人邮箱
     * @param receiveMail :收件人邮箱
     * @throws MessagingException 
     * @throws UnsupportedEncodingException 
     */
    public static void createMimeMessage(String receiveMail,String title,String text) throws UnsupportedEncodingException, MessagingException {
    	//1.创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol","smtp");// 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host","smtp.163.com"); // 发件人的邮箱的 SMTP 服务器地址
        //props.setProperty("mail.smtp.host","smtp.qq.com");
        props.setProperty("mail.smtp.auth", "true");    // 需要请求认证
        
        //2.根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props);
        session.setDebug(true);//设置为调错模式
        
        //3.创建一封邮件
        MimeMessage message = new MimeMessage(session);
        
        //4.设置发件人
        message.setFrom(new InternetAddress("sunyutong20010820@163.com","金钱规"));
        
        //5.设置收件人To: 收件人（可以增加多个收件人、抄送、密送）CC:抄送人，BCC:密送
        message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(receiveMail,"utf-8"));
        
        //6.Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
        message.setSubject(title, "UTF-8");
 
        //7. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
        message.setContent(text, "text/html;charset=utf-8");
 
        //8. 设置发件时间
        message.setSentDate(new Date());
 
        //9. 保存设置
        message.saveChanges();
        
        //10.根据 Session 获取邮件传输对象
        Transport transport = session.getTransport();
        
        //11.连接SMTP服务器
        transport.connect(sendEmailAccount, sendEmailPwd);
        
        //12.发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(message, message.getAllRecipients());
        
        //13.关闭连接
        transport.close();
    }
}
