package com.lalmondev.online_resume.util;

import com.lalmondev.online_resume.model.ResumeEntity;
import com.lalmondev.online_resume.service.ResumeService;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

import javax.annotation.Resource;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class BuildResumeTool {

    @Resource(name = "resumeServiceImpl")
    private ResumeService resumeService;

    public Boolean BuildResume(String user_name,String style,ResumeEntity resumeEntity ){
        String styleName = style + ".ftl";
        String targetTexName = user_name + ".tex";
        String userDirPath = "G:/FinalDesign/online_resume_web/static/pdf/resumes/" + user_name;
        String templatePath = "G:/FinalDesign/src/main/resources/templates/";

        RuntimeTool runtime = new RuntimeTool();
        ResumeEntity MapEntity = resumeEntity;
        System.out.println(resumeEntity);
        Map root = new HashMap();
        root.put("info",resumeEntity.getName());

        try {
            // 去到用户目录，结合模板，生成tex文件
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
            cfg.setDirectoryForTemplateLoading(new File(templatePath));
            cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_28));

            Template temp = cfg.getTemplate(styleName);
            File file = new File( userDirPath + "/" + targetTexName);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            temp.process(root, bw);
            bw.flush();
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        //编译tex文件，生成简历PDF
        String command = "lualatex " + targetTexName;
        if (!runtime.CMDTool(command,userDirPath)){
            return false;
        }

        return true;
    }

}
