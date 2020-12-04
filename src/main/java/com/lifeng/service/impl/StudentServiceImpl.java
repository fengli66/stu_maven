package com.lifeng.service.impl;

import com.lifeng.dao.student.StudentMapper;
import com.lifeng.pojo.PageIndexer;
import com.lifeng.pojo.Student;
import com.lifeng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {
//    SqlSession sqlSession;

    //对dao层对象的私有属性封装
    @Autowired
    private StudentMapper studentMapper;

    public StudentMapper getStudentMapper() {
        return studentMapper;
    }

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    /**
     * 获取student条数总数
     *
     * @return
     */
    @Override
    public int getCount() {
        int count = studentMapper.getCount();
        return count;
    }

    /**
     * 分页
     *
     * @param page
     * @return
     */
    @Override
    public List<Student> findStudentPage(PageIndexer page) {
        List<Student> studentList = new ArrayList<>();
        studentList = studentMapper.getStudentsByPage(page);
        return studentList;
    }

    /**
     * 查找所有
     *
     * @return
     */
    @Override
    public List<Student> findAll() {
        List<Student> students = studentMapper.findAll();
        //判断是否找到数据
        if (students.size() < 0) {
            students = null;
        }
        return students;
    }

    /**
     * 按id查询
     *
     * @param id
     * @return
     */
    @Override
    public Student findById(int id) {
        Student student = studentMapper.findById(id);
        if (student == null) {
            student = null;
        }
        return student;
    }


    /**
     * 1,先找到用没有该id
     * 2，根据id进行修改
     * 3，flag -1：没有该用户
     * 1：修改成功
     * 0：修改失败
     *
     * @param student
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int editByid(Student student) {
        int flag = -1;
        if (studentMapper.findById(student.getId()) != null) {
            flag = 0;
            if (studentMapper.editByid(student)) {
                flag = 1;
            }
        }
        return flag;
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteById(int id) {
        boolean b = studentMapper.deleteById(id);
        return b;
    }

    /**
     * 插入
     *
     * @param student
     * @return 成功返回1 学生已存在返回0 其他返回-1
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insert(Student student) {
        int flag = -1;
        if (studentMapper.findById(student.getId()) != null) {
            flag = 0;
        } else {
            if (studentMapper.insert(student)) {
                flag = 1;
            }
        }
        return flag;
    }

    /**
     * 查询
     *
     * @param name
     * @return 查询到name 返回true，否则返回false
     */
    @Override
    public String findByName(String name) {
        String result = "false";
        if (studentMapper.findByName(name) == null) {
            result = "true";
        }
        return result;
    }

    /**
     * 模糊查询用户名
     *
     * @param txtsearch
     * @return 返回一个拼接字符串
     */
    @Override
    public String findByLikeName(String txtsearch) {
        String result = "";
        List<Student> students = studentMapper.findByLikeName(txtsearch);
        for (Student student : students) {
            result += student.getName() + "-";
        }
        result = result.substring(0, result.length() - 1);
        return result;
    }

    /**
     * @param student
     * @return
     */
    @Override
    public int fileUpload(Student student) {
        int flag = 0;
        if (studentMapper.editByid(student)) {
            flag = 1;
        }
        return flag;
    }

}
