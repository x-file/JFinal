package com.sa.java;
import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.sa.java.modules.sys.control.IndexController;
import com.sa.java.modules.sys.control.UserController;

/**
 * API引导式配置
 * Created by sa
 * Date: 2016/1/13 17:57
 */
public class AppConfig extends com.jfinal.config.JFinalConfig {

    /**
     * 配置常量
     * @param me
     */
    @Override
    public void configConstant(Constants me) {
        // 加载少量必要配置，随后可用PropKit.get(...)获取值
        PropKit.use("com/sa/java/common/config/config.properties");
        // me.setViewType(ViewType.FREE_MARKER);
    }

    /**
     * 配置路由
     * @param me
     */
    @Override
    public void configRoute(Routes me) {
        me.add("/", IndexController.class,"/WEB-INF/view/modules/sys");
        me.add("/user", UserController.class,"/WEB-INF/view/modules/sys");
    }



    /**
     * 配置插件
     * @param me
     */
    @Override
    public void configPlugin(Plugins me) {
        //数据库连接池
        C3p0Plugin c3p0Plugin = createC3p0Plugin();
        //ORM Activerecord
        ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
        arp.setShowSql(true);
        //arp.addMapping("sys_user", User.class);

        me.add(c3p0Plugin);
        me.add(arp);
    }

    /**
     * 配置全局拦截器
     * @param me
     */
    @Override
    public void configInterceptor(Interceptors me) {

    }

    /**
     * 配置处理器
     * @param me
     */
    @Override
    public void configHandler(Handlers me) {

    }


    public static C3p0Plugin createC3p0Plugin() {
        return new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
    }
}
