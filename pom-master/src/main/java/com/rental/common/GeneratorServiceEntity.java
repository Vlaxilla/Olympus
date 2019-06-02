package com.rental.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * <p>
 * Code generator demo
 * </p>
 */
public class GeneratorServiceEntity {

    /**
     * <p>
     * MySQL generate demo
     * </p>
     */
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        TemplateConfig tplCfg = new TemplateConfig();
        mpg.setTemplate(tplCfg);
        // Choose freemarker Engine, default Veloctiy
        // mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // Global configuration
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("Y://temp");
        gc.setFileOverride(true);
        gc.setActiveRecord(false);// False if you don't need ActiveRecord features
        gc.setEnableCache(false);// XML level 2 cache
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        // .setKotlin(true) Whether to generate kotlin code
        gc.setAuthor("rental");
        // Custom file naming, note that %s automatically populates table entity properities
        // gc.setMapperName("%sDao");
        // gc.setXmlName("%sDao");
        // gc.setServiceName("MP%sService");
        // gc.setServiceImplName("%sServiceDiy");
        // gc.setControllerName("%sAction");
        mpg.setGlobalConfig(gc);

        // Data source configuration?
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            // Custom database table field type conversion [optional]??
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("Conversion type:?" + fieldType);
                // Attention!!! ProcessTypeConvert has default type conversion, if not the effect you want, please custom return, not directly return.?
                return super.processTypeConvert(fieldType);
            }
        });
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://localhost:3306/rental?characterEncoding=utf8");
        mpg.setDataSource(dsc);

        //Policy configuration
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// Global upper case named ORACLE note
        /*strategy.setTablePrefix(new String[] { "tlog_", "tsys_" });*/
        /*strategy.setTablePrefix(new String[] { "user" });// You can cahnge this to your table prefix */
        strategy.setNaming(NamingStrategy.underline_to_camel);// Table name generation strategy
        strategy.setInclude(new String[]{"car","comment","information","location"
        ,"location_car","orders","user"}); // Table to generate
        // strategy.setExclude(new String[]{"test"}); // Exclude generated tables
        // Custom entity superclasses
        // strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
        // Custom entities,public fields
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // Customize the mapper parent class
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // Customize the service parent class
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // Custom service implementation class superclass
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // Customize the controller superclass
        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
        // [entity] whether to generate field constants (default false)
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // [entity] is the builder model (default false)
        // public Customer setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuilderModel(true);
        mpg.setStrategy(strategy);

        // Package configuration
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.rental");
        mpg.setPackageInfo(pc);

        // Inject custom configuration to use cfg.abc in VMS??
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                map.put("dueape", "com.dueape.admin");
                this.setMap(map);
            }
        };

        // Custom xxList.jsp generation 
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
/*        focList.add(new FileOutConfig("/template/list.jsp.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // Customize the input file name
                return "D://my_" + tableInfo.getEntityName() + ".jsp";
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);*/

        // Adjust the xml generation directory demo
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return "/develop/code/xml/" + tableInfo.getEntityName() + ".xml";
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // Turnoff the default xml generation and adjust the generation to the root directory
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);


        //The custom temple configuration,you can copy the source code mybatis-plus/src/main/resources/templates modify the following content
        //Placed his project of src/main/resources/templates directory,the default name can not configuration, can also custom template name
        //    TemplateConfig tc = new TemplateConfig();
        tc.setController("/vm/controller.java.vm");
        tc.setEntity("/vm/entity.java.vm");
        tc.setMapper("/vm/mapper.java.vm");
        tc.setService("/vm/service.java.vm");
        tc.setServiceImpl("/vm/serviceImpl.java.vm");
        mpg.setTemplate(tc);
        // Any of the above modules will not be generated if NULL OR NULL is set.?
       mpg.setCfg(customerConfig("/vm/InfoBean.vm","Y://temp"));
     // mpg.setCfg(docConfig("/vm/doc.vm", "Y://temp"));
        //Perform genarated
        mpg.execute();


        System.out.println(mpg.getCfg());
        System.out.println(mpg.getCfg().getMap());
        System.out.println(mpg.getCfg().getMap().get("dueape"));

    }


    private static InjectionConfig customerConfig(String vmPath, String output) {
        InjectionConfig config = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                map.put("dueape", "com.dueape.admin");
                this.setMap(map);
            }
        };
        List<FileOutConfig> files = new ArrayList<FileOutConfig>();
        files.add(new FileOutConfig(vmPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String expand = output + "/" + "expand/";
                String entityFile = String.format(("%sInfoBean" + ".java"), tableInfo.getEntityName());
                return expand + entityFile;
            }
        });
        config.setFileOutConfigList(files);
        return config;
    }

    private static InjectionConfig docConfig(String vmPath, String output) {
        InjectionConfig config = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                map.put("dueape", "com.dueape.admin");
                this.setMap(map);
            }
        };
        List<FileOutConfig> files = new ArrayList<FileOutConfig>();
        files.add(new FileOutConfig(vmPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String expand = output + "/" + "doc/";
                String entityFile = String.format(("%s" + ".txt"), tableInfo.getEntityName());
                return expand + entityFile;
            }
        });
        config.setFileOutConfigList(files);
        return config;
    }

}