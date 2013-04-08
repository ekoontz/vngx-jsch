package org.vngx.jsch;

import org.vngx.jsch.config.SessionConfig;
import org.vngx.jsch.exception.JSchException;
import org.vngx.jsch.userauth.Identity;
import org.vngx.jsch.userauth.IdentityFile;
import org.vngx.jsch.userauth.IdentityManager;
import org.vngx.jsch.util.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: ekoontz
 * Date: 4/3/13
 * Time: 12:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class Ssh {

   public static void main(String argv[]) {
     JSch jSch = JSch.getInstance();
     try {
       Session session = jSch.createSession("ekoontz","centos1.local");
       JSch.getLogger().log(Logger.Level.INFO, "Successfully connected.");
       session.getConfig().setProperty(SessionConfig.STRICT_HOST_KEY_CHECKING,
         "no");
       //IdentityManager.getManager().addIdentity("/Users/ekoontz/.ssh/id_rsa");
       session.connect();
       //session.run();
       try {Thread.sleep(10);} catch (InterruptedException e ){}
       session.disconnect();
       System.out.println("connected and disconnected successfully.");
     } catch (JSchException e) {
       JSch.getLogger().log(Logger.Level.ERROR,
         "Got exception when trying to create the session.",e);
     }
     return;
   }


}
