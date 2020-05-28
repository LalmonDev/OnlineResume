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

    public Boolean BuildResume(String user_name,String style,ResumeEntity resumeEntity){
        String styleName = style + ".ftl";
        String targetTexName = user_name + ".tex";
        String userDirPath = "G:/FinalDesign/online_resume_web/static/pdf/web/resumes/" + user_name + "/" + style;
        String templatePath = "G:/FinalDesign/src/main/resources/templates/";

        RuntimeTool runtime = new RuntimeTool();
        ResumeEntity MapEntity = resumeEntity;

        // 数据赋值到模板
        Map root = new HashMap();
        root.put("name",MapEntity.getName());
        root.put("sex",MapEntity.getSex());
        root.put("nation",MapEntity.getNation());
        root.put("date",MapEntity.getDate());
        root.put("face",MapEntity.getFace());
        root.put("marry",MapEntity.getMarry());
        root.put("home",MapEntity.getHome());
        root.put("phone",MapEntity.getPhone());
        root.put("mail",MapEntity.getMail());
        root.put("job",MapEntity.getJob());
        root.put("city",MapEntity.getCity());
        root.put("money",MapEntity.getMoney());
        root.put("study_start_day",MapEntity.getStudy_start_day());
        root.put("study_stop_day",MapEntity.getStudy_stop_day());
        root.put("school",MapEntity.getSchool());
        root.put("major",MapEntity.getMajor());
        root.put("degree",MapEntity.getDegree());
        root.put("school_descrip",MapEntity.getSchool_descrip());
        root.put("skill",MapEntity.getSkill());
        root.put("job_experience",MapEntity.getJob_experience());
        root.put("school_experience",MapEntity.getSchool_experience());
        root.put("award",MapEntity.getAward());
        root.put("interest",MapEntity.getInterest());
        root.put("evaluate",MapEntity.getEvaluate());


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
        String command = "xelatex " + targetTexName;
        if (!runtime.CMDTool(command,userDirPath)){
            return false;
        }

        return true;
    }

}
