package com.lalmondev.online_resume.controller;

import com.lalmondev.online_resume.util.RuntimeTool;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @RequestMapping("/hello")
    public void hello() {

        String styleStr = "style1";
        String userName = "张三";

        String styleName = styleStr + ".ftl";
        String targetFileName = styleStr + ".tex";
        String targetFilePath = "G:/FinalDesign/online_resume_web/static/pdf/resumes/";
        String templateFilePath = "G:/FinalDesign/src/main/resources/templates/";
        String cmd = "mkdir "+userName;
        RuntimeTool runtime = new RuntimeTool();
        runtime.CMDTool(cmd,targetFilePath);

        try {

//            Map root = new HashMap();
//            root.put("package", "com.chinaoly.job.entity");
//            root.put("user", "cunxp");
//            root.put("date", "2018/08/31");
//            root.put("tableName", "task");
//            root.put("className", "Task");
//            List data = new ArrayList();
//            data.add("@Column(name = \"task_name\")\nprivate String taskName;\n");
//            data.add("@Column(name = \"task_description\")\nprivate String taskDescription;\n");
//            data.add("@Column(name = \"file_name\")\nprivate String fileName; \n");
//            root.put("data", data);

            Map root = new HashMap();
            root.put("title","测试文档");
            root.put("author","Lalmon");
            root.put("info","there is info\n\nHello");

            Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
            cfg.setDirectoryForTemplateLoading(new File(templateFilePath));
            cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_28));

            Template temp = cfg.getTemplate(styleName);
            File file = new File( targetFilePath + userName+"/" + targetFileName);

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            temp.process(root, bw);

            bw.flush();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        String command = "lualatex " + targetFileName;
        runtime.CMDTool(command,targetFilePath+ userName);

        System.out.println(command);
        System.out.println(targetFilePath+ userName);

    }
}
