package com.lifeng.controller;

import com.lifeng.pojo.PageIndexer;
import com.lifeng.pojo.Student;
import com.lifeng.service.StudentService;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

/**
 * student的控制层
 *
 * @author fengli
 * @version 1.0
 * @date 2020/11/25
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 添加学生信息
     *
     * @param student
     * @param model
     * @return
     */
    @RequestMapping(value = "/addStudent.do")
    private String addStudent(Student student, Model model) {
        System.out.println("添加学生");

        int flag = studentService.insert(student);
        if (flag == 1) {
            System.out.println("成功添加");
        return "redirect:list.do";
        } else if (flag == 0) {
            System.out.println("学生id已存在");
            return "addlist";
        } else {
            System.out.println("空间已满");
            return "addlist";
        }
    }

    /**
     * 按id查询学生信息
     *
     * @param id
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/findByid.do")
    private String findByid(@RequestParam(value = "code", required = true) Integer id, Model model) throws Exception {
        System.out.println("按id查询学生信息");
        //页面传来的id
        System.out.println("id" + id);
        //使用业务逻辑层
        Student student = null;
        student = studentService.findById(id);
        if (student == null) {
            System.out.println("没有该id的用户");
            return "index";
        } else {
            model.addAttribute("student", student);
            return "editStudentInfo";
        }
    }

    /**
     * 修改学生信息
     *
     * @param student
     * @param model
     * @return
     */
    @RequestMapping(value = "/editStudent.do")
    private String editStudent(Student student, Model model) {

        //调用业务逻辑层
        System.out.println("student="+student);
        int flag = studentService.editByid(student);
        if (flag == 1) {
            System.out.println("成功修改");
            return "redirect:list.do";
        } else {
            System.out.println("没有该学生");
            return "redirect:list.do";
        }
    }

    /**
     * 删除学生信息
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/delStudentInfo.do")
    private String delStudentInfo(@RequestParam(value = "ids") int id, Model model) {
            //获取页面id
            System.out.println("id=" + id);
            boolean flag = studentService.deleteById(id);
            if (flag) {
                return "redirect:list.do";
            }else {
                return "error";
            }
    }

    /**
     * loginFrom是验证表单数据是否存在数据库中
     * result=true;已存在
     * result=false:可以使用
     *
     * @param student
     * @param model
     * @return
     */
    @RequestMapping(value = "/loginform.do")
    private String loginform(Student student, Model model) {

        String result = "false";

        if (studentService.findByName(student.getName()) == null) {
            result = "true";
        }
        model.addAttribute("result", result);
        return null;
    }

    /**
     * 使用Ajax实现自动提示
     *
     * @param str
     * @param model
     * @return
     *
     */
    @RequestMapping(value = "/SearchSuggest.do")
    private String SearchSuggest(@RequestParam(value = "txtSearch", required = false) String str, Model model) {

        String result = studentService.findByLikeName(str);
        model.addAttribute("result", result);
        return "autoSearch";
    }

    /**
     *  student信息分页
     * @param index page的下标，第几页了
     * @param model
     * @return
     */
    @RequestMapping(value = "/list.do")
    private String studentList(@RequestParam(value = "pageIndex",required = false) Integer index, Model model){
        System.out.println("sss");
        int pageindex, pageSize, pageCount;
        PageIndexer page = new PageIndexer(1, 5, 0);
        //判断是否已经保存了分页session
        ;
        if (index != null) {
            page.setPageIndex(index);
        }
        List<Student> studentList = null;
        try {
            studentList = studentService.findStudentPage(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //获取所有student获取总数
        page.setPageCount((int) Math.ceil(studentService.findAll().size() * 1.0 / page.getPageSize()));
        model.addAttribute("studentList", studentList);
        model.addAttribute("pb", page);
        return "studentlist";
    }

    /**
     * 处理 普通数据项
     *
     * @param item
     */
    private Student handleFormField(FileItem item) {
        // 获取 普通数据项中的 各项值
        String fieldName = item.getFieldName();
        // 获取 普通数据项中的 value值
        String value = "";
        try {
            value = item.getString("utf-8");  // 以 utf-8的编码格式来解析 value值
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 表单中的name值
        if (fieldName.equals("name")) {
//            name = value;
        }
        //表单中的code值
        if (fieldName.equals("code")) {
//            code = Integer.parseInt(value);
        }
        //表单中的sex
        if (fieldName.equals("sex")) {

//            sex = value;
//            System.out.println("sex" + sex);
//            if (sex == "男") {
//                sex = "1";
//            } else {
//                sex = "0";
//            }
        }
        //表单的score
        if (fieldName.equals("score")) {
//            score = Double.parseDouble(value);
        }
        Student student = new Student();
//        student.setId(code);
//        student.setName(name);
//        student.setSex(Byte.parseByte(sex));
//        student.setScore(score);
        return student;
    }


    /**
     * 处理 文件数据项
     *
     * @param item
     */
    private String handleFileField(FileItem item) {
        String imageName = "";
        // 获取 文件数据项中的 文件名
        String fileName = item.getName();
        // 判断 此文件的文件名是否合法
        if (fileName == null || "".equals(fileName)) {
            return "";
        }
        // 控制只能上传图片
        if (!item.getContentType().startsWith("image")) {
            return "";
        }
        // 将文件信息 输出到控制台
        System.out.println("fileName:" + fileName);         // 文件名
        System.out.println("fileSize:" + item.getSize());   // 文件大小

        // 获取 当前项目下的 /files 目录的绝对位置
//        String path = this.getServletContext().getRealPath("/files");
        String path = ""/*this.getServletContext().getRealPath("/files")*/;
        System.out.println(path);
        File file = new File(path);   // 创建 file对象

        // 创建 /files 目录
        if (!file.exists()) {
            file.mkdir();
        }
        // 将文件保存到服务器上（UUID是通用唯一标识码，不用担心会有重复的名字出现）
        try {
            item.write(new File(file.toString(), UUID.randomUUID() + "_" + fileName));
            System.out.println(UUID.randomUUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }

}
