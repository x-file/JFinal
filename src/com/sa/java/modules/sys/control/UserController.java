package com.sa.java.modules.sys.control;

import com.jfinal.core.Controller;

/**
 * Created by sa
 * Date: 2016/2/16 9:15
 */
public class UserController extends Controller{
    public void index(){
        //render("/WEB-INF/view/modules/sys/user.html");
        render("table.html");
    }
    public void user(){
        render("table.html");
    }
}
