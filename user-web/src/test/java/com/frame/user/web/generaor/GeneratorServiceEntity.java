package com.frame.user.web.generaor;

/**
 * Created by Administrator on 2018/6/14.
 */

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * <p>
 * 测试生成代码
 * </p>
 *
 * @date 2017/12/18
 */
public class GeneratorServiceEntity {

    @Test
    public void generateCode() {
        String packageName = "com.frame.user.web";
        boolean serviceNameStartWithI = true;//user -> UserService, 设置成true: user -> IUserService
        String[] tableNames = {"t_user","t_user_detail","t_user_role","t_role","t_permission","t_role_permission"};
        generateByTables(serviceNameStartWithI, packageName, tableNames);
    }

    private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://47.106.212.169:3306/frame-user?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("root")
                .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(false)
               // .setDbColumnUnderline(true)
                .setTablePrefix(new String[]{"t_"})// 此处可以修改为您的表前缀
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false)
                .setAuthor("derrick")
                .setOutputDir("/Users/lemonade/code/frame/frame-user/user-web/")
                .setBaseResultMap(true) // 基本的字段映射
                .setBaseColumnList(true) // 基本的sql片段
                .setFileOverride(true).setSwagger2(true);

        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }
       PackageConfig packageConfig =  new PackageConfig()
                .setParent(packageName)
                //.setController("controller")
                .setEntity("entity")
                .setMapper("mapper")
                .setEntity("entity");
               //.setService("service");
        /*TemplateConfig tc = new TemplateConfig();
        tc.setController("/templates/controller.java.vm");
        tc.setService("/templates/service.java.vm");
        tc.setServiceImpl("/templates/serviceImpl.java.vm");
        tc.setEntity("/templates/entity.java.vm");
        tc.setMapper("/templates/mapper.java.vm");*/

        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig
                ).execute();


    }

   /* private void generateByTables(String packageName, String... tableNames) {
        generateByTables(true, packageName, tableNames);
    }*/
}
