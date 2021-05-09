package com.googlevip8.lspCrawler.config;

import java.io.InputStream;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;

/**
 * 如需访问外网，请设置java代理
 */
public class JavaProperyConfig {

    public void setPropery(){
        System.setProperty( "http.proxyHost" , "127.0.0.1" );
        System.setProperty( "http.proxyPort" , "7890" );
        System.setProperty( "https.proxyHost" , "127.0.0.1" );
        System.setProperty( "https.proxyPort" , "7890" );
//        Authenticator authenticator = new BasicAuthenticator("username","password");
//        Authenticator.setDefault(authenticator);
    }

    public static void main(String[] args) throws Exception {
        JavaProperyConfig javaProperyConfig = new JavaProperyConfig();
        javaProperyConfig.setPropery();
        URL url = new URL("https://cn.pornhub.com/view_video.php?viewkey=ph608daa9b849d8");
        URLConnection connection = url.openConnection();
        connection.connect();
        InputStream inputStream = connection.getInputStream();
        //读取结果
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes) >= 0) {
            System.out.println(new String(bytes));
        }
    }
}

class BasicAuthenticator extends Authenticator{
    private String userName;
    private String password;

    public BasicAuthenticator(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName,password.toCharArray());
    }
}
