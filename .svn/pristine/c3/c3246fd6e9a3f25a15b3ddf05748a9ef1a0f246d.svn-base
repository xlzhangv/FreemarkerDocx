package com.xlzhang.word;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * <p>
 * 示例：
 * dataMap.put("list", brochures.getCatalogs());<br/>
 * FreeMarkerWordUtil.getInstance().setConfig(ServletActionContext.getServletContext(), "/freemarker")<br/>
 * .createWord(out, "template.xml", dataMap);<br/>
 * </P
 * 功能: FreeMarker 生成word.<br/>
 * date: 2016�?6�?15�? 下午6:18:31 <br/>
 *
 * @author xlzhang@wisdombud.com
 * @version
 * @since JDK 1.7
 */
public class FreeMarkerWordUtil {

    private static FreeMarkerWordUtil wordUtil;
    private Configuration configuration;

    public static FreeMarkerWordUtil getInstance() {
        if (wordUtil == null) {
            wordUtil = new FreeMarkerWordUtil();
        }
        return wordUtil;
    }

    /**
     * 功能: TODO.<br/>
     * date: 2016�?6�?15�? 下午6:18:02 <br/>
     *
     * @author xdwang@wisdombud.com
     * @param servletContext {@code javax.servlet.ServletContext}
     * @param templatedir /freemarker
     * @return
     */
    public FreeMarkerWordUtil setConfig(Object servletContext, String templatedir) {
        // 创建配置实例
        configuration = new Configuration();
        // 兼容是否允许为空
        configuration.setClassicCompatible(true);
        // 设置编码
        configuration.setDefaultEncoding("UTF-8");
        // ftl模板文件统一放至 com.* 包下�?
        configuration.setServletContextForTemplateLoading(servletContext, templatedir);
        return wordUtil;
    }
    
    public FreeMarkerWordUtil buildConfig(BuildConfiguration build) {
        // 创建配置实例
        configuration = new Configuration();
        // 兼容是否允许为空
        configuration.setClassicCompatible(true);
        // 设置编码
        configuration.setDefaultEncoding("UTF-8");
        build.setConfig(configuration);
        // ftl模板文件统一放至 com.* 包下�?
        return wordUtil;
    }

    /**
     * @Desc：生成word文件
     * @Date�?2014-1-22下午05:33:42
     * @param dataMap word中需要展示的动�?�数据，用map集合来保�?
     * @param templateName word模板名称，例如：test.ftl
     */
    @SuppressWarnings("unchecked")
    public void createWord(final OutputStream outFile, final String templateName, final Map dataMap) {

        try {
            // 获取模板
            final Template template = configuration.getTemplate(templateName);

            // 将模板和数据模型合并生成文件
            final Writer out = new BufferedWriter(new OutputStreamWriter(outFile, "UTF-8"));

            // 生成文件
            template.process(dataMap, out);

            // 关闭�?
            out.flush();
            out.close();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * @Desc：生成word文件
     * @Date�?2014-1-22下午05:33:42
     * @param dataMap word中需要展示的动�?�数据，用map集合来保�?
     * @param templateName word模板名称，例如：test.ftl
     */
    @SuppressWarnings("unchecked")
    public void createWord(final OutputStream outFile, final String templateName, final Object dataMap) {

        try {
            // 获取模板
            final Template template = configuration.getTemplate(templateName);

            // 将模板和数据模型合并生成文件
            final Writer out = new BufferedWriter(new OutputStreamWriter(outFile, "UTF-8"));

            // 生成文件
            template.process(dataMap, out);

            // 关闭�?
            out.flush();
            out.close();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
