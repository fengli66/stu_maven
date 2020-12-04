package com.lifeng.service;




import com.lifeng.pojo.PageIndexer;
import com.lifeng.pojo.Student;

import java.util.List;

/**
 * 业务逻辑层
 * @author fengli
 * @date 2020/11/05
 * @version 1.0
 */
public interface StudentService {

    int getCount();
    /**
     * 分页
     * @param page
     * @return
     */
    public List<Student> findStudentPage(PageIndexer page);

    /**
     * 查询所有
     * @return
     */
    public List<Student> findAll();

    /**
     * 按id查询
     * @param id
     * @return
     */
    public Student findById(int id);

    /**
     * 修改
     */

    public int editByid(Student student);

    /**
     * 删除
     * @param id
     * @return
     */
    public boolean deleteById(int id);

    /**
     * 插入
     * @param student
     * @return
     */
    public int insert(Student student);

    /**
     * 查询name
     * @param name
     * @return
     */
    public String findByName(String name);
    /**
     * 按照文本模糊查找用户名
     * @param txtsearch
     * @return
     */
    String findByLikeName(String txtsearch);

    /**
     * 文件上传
     * @param student
     * @return
     */
    int fileUpload(Student student);
}
