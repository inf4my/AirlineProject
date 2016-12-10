package Controller;

import BusinessLayer.Customer;
import DataLinkLayer.CustomerAL;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * Created by lionery on 30/11/2016.
 */
public class ControllerMasuk {
    @FXML
    JFXButton btnBatal;

    @FXML
    JFXTextField txtUsername;

    @FXML
    JFXPasswordField txtPassword;

    public void handleBtnBatal(){
        btnBatal.getScene().getWindow().hide();
    }

    private MessageDigest digest;

    private String hash(String strToHash){
        try{
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(strToHash.getBytes(StandardCharsets.UTF_8));
            return DatatypeConverter.printHexBinary(hash);
        }
        catch(Exception ex){
            ex.printStackTrace();
            return "";
        }
    }

    public void handleBtnMasuk() throws Exception{
        Customer customer = null;
        String usernameIn = txtUsername.getText();
        String pass = txtPassword.getText();
        String passwordIn = hash(pass);
        //System.out.println(passwordIn);
        customer.login(usernameIn, passwordIn);
        CustomerAL check = new CustomerAL();
        check.getUser(usernameIn,passwordIn);

        //ga bs masuk databasenya

        /*
    java.lang.ClassNotFoundException: com.mysql.jdbc.Driver
	at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:331)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at java.lang.Class.forName0(Native Method)
	at java.lang.Class.forName(Class.java:264)
	at DataLinkLayer.ConnectionConfiguration.getConnection(ConnectionConfiguration.java:18)
	at DataLinkLayer.CustomerAL.connect(CustomerAL.java:18)
	at DataLinkLayer.CustomerAL.insertUser(CustomerAL.java:42)
	at Controller.ControllerSignUp.handleBtnDaftar(ControllerSignUp.java:37)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at sun.reflect.misc.Trampoline.invoke(MethodUtil.java:71)
	at sun.reflect.GeneratedMethodAccessor1.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at sun.reflect.misc.MethodUtil.invoke(MethodUtil.java:275)
	at javafx.fxml.FXMLLoader$MethodHandler.invoke(FXMLLoader.java:1771)
	at javafx.fxml.FXMLLoader$ControllerMethodEventHandler.handle(FXMLLoader.java:1657)
	at com.sun.javafx.event.CompositeEventHandler.dispatchBubblingEvent(CompositeEventHandler.java:86)
	at com.sun.javafx.event.EventHandlerManager.dispatchBubblingEvent(EventHandlerManager.java:238)
	at com.sun.javafx.event.EventHandlerManager.dispatchBubblingEvent(EventHandlerManager.java:191)
	at com.sun.javafx.event.CompositeEventDispatcher.dispatchBubblingEvent(CompositeEventDispatcher.java:59)
	at com.sun.javafx.event.BasicEventDispatcher.dispatchEvent(BasicEventDispatcher.java:58)
	at com.sun.javafx.event.EventDispatchChainImpl.dispatchEvent(EventDispatchChainImpl.java:114)
	at com.sun.javafx.event.BasicEventDispatcher.dispatchEvent(BasicEventDispatcher.java:56)
	at com.sun.javafx.event.EventDispatchChainImpl.dispatchEvent(EventDispatchChainImpl.java:114)
	at com.sun.javafx.event.BasicEventDispatcher.dispatchEvent(BasicEventDispatcher.java:56)
	at com.sun.javafx.event.EventDispatchChainImpl.dispatchEvent(EventDispatchChainImpl.java:114)
	at com.sun.javafx.event.EventUtil.fireEventImpl(EventUtil.java:74)
	at com.sun.javafx.event.EventUtil.fireEvent(EventUtil.java:49)
	at javafx.event.Event.fireEvent(Event.java:198)
	at javafx.scene.Node.fireEvent(Node.java:8411)
	at javafx.scene.control.Button.fire(Button.java:185)
	at com.sun.javafx.scene.control.behavior.ButtonBehavior.mouseReleased(ButtonBehavior.java:182)
	at com.sun.javafx.scene.control.skin.BehaviorSkinBase$1.handle(BehaviorSkinBase.java:96)
	at com.sun.javafx.scene.control.skin.BehaviorSkinBase$1.handle(BehaviorSkinBase.java:89)
	at com.sun.javafx.event.CompositeEventHandler$NormalEventHandlerRecord.handleBubblingEvent(CompositeEventHandler.java:218)
	at com.sun.javafx.event.CompositeEventHandler.dispatchBubblingEvent(CompositeEventHandler.java:80)
	at com.sun.javafx.event.EventHandlerManager.dispatchBubblingEvent(EventHandlerManager.java:238)
	at com.sun.javafx.event.EventHandlerManager.dispatchBubblingEvent(EventHandlerManager.java:191)
	at com.sun.javafx.event.CompositeEventDispatcher.dispatchBubblingEvent(CompositeEventDispatcher.java:59)
	at com.sun.javafx.event.BasicEventDispatcher.dispatchEvent(BasicEventDispatcher.java:58)
	at com.sun.javafx.event.EventDispatchChainImpl.dispatchEvent(EventDispatchChainImpl.java:114)
	at com.sun.javafx.event.BasicEventDispatcher.dispatchEvent(BasicEventDispatcher.java:56)
	at com.sun.javafx.event.EventDispatchChainImpl.dispatchEvent(EventDispatchChainImpl.java:114)
	at com.sun.javafx.event.BasicEventDispatcher.dispatchEvent(BasicEventDispatcher.java:56)
	at com.sun.javafx.event.EventDispatchChainImpl.dispatchEvent(EventDispatchChainImpl.java:114)
	at com.sun.javafx.event.EventUtil.fireEventImpl(EventUtil.java:74)
	at com.sun.javafx.event.EventUtil.fireEvent(EventUtil.java:54)
	at javafx.event.Event.fireEvent(Event.java:198)
	at javafx.scene.Scene$MouseHandler.process(Scene.java:3757)
	at javafx.scene.Scene$MouseHandler.access$1500(Scene.java:3485)
	at javafx.scene.Scene.impl_processMouseEvent(Scene.java:1762)
	at javafx.scene.Scene$ScenePeerListener.mouseEvent(Scene.java:2494)
	at com.sun.javafx.tk.quantum.GlassViewEventHandler$MouseEventNotification.run(GlassViewEventHandler.java:380)
	at com.sun.javafx.tk.quantum.GlassViewEventHandler$MouseEventNotification.run(GlassViewEventHandler.java:294)
	at java.security.AccessController.doPrivileged(Native Method)
	at com.sun.javafx.tk.quantum.GlassViewEventHandler.lambda$handleMouseEvent$354(GlassViewEventHandler.java:416)
	at com.sun.javafx.tk.quantum.QuantumToolkit.runWithoutRenderLock(QuantumToolkit.java:389)
	at com.sun.javafx.tk.quantum.GlassViewEventHandler.handleMouseEvent(GlassViewEventHandler.java:415)
	at com.sun.glass.ui.View.handleMouseEvent(View.java:555)
	at com.sun.glass.ui.View.notifyMouse(View.java:937)
	at com.sun.glass.ui.win.WinApplication._runLoop(Native Method)
	at com.sun.glass.ui.win.WinApplication.lambda$null$148(WinApplication.java:191)
	at java.lang.Thread.run(Thread.java:745)

        */


    }

    @FXML
    public void handleBtnDaftar(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("signUp.fxml"));
            Parent entryForm = loader.load();
            Stage entryStage = new Stage();
            entryStage.setTitle("Pendaftaran");
            entryStage.setScene(new Scene(entryForm,489,357));
            entryStage.show();
            entryStage.requestFocus();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
