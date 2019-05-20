package Handle.UserMessage;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.Map;

/**
 * Created by Sniper on 2018/4/20.
 */
public class UserMessage {
    public String UserMessage(){
        Map<String, String> map = System.getenv();
        String userName = map.get("USERNAME");// 获取用户名
        String computerName = map.get("COMPUTERNAME");// 获取计算机名
        String userDomain = map.get("USERDOMAIN");// 获取计算机域名
//        System.out.println(userName);
//        System.out.println(computerName);
//        System.out.println(userDomain);
        return "UserName:"+userName+"\tComputerName:"+computerName;
    }
    public static void main(String[] args){
        new UserMessage().UserMessage();
    }
}
