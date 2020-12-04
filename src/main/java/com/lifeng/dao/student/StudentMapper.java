package com.lifeng.dao.student;


import com.lifeng.pojo.PageIndexer;
import com.lifeng.pojo.Student;

import java.util.List;

/**
 * 数据操作接口
 *
 * @author fengli
 * @version 1.0 2020/10/16
 */
public interface StudentMapper {

    /**
     * 查询所有
     */

    List<Student> findAll();

    /**
     * 按id查询
     *
     * @param id
     * @return
     */
    Student findById(int id);

    /**
     * 根据name查询
     *
     * @return
     */
    Student findByName(String name);

    /**
     * 修改
     *
     * @param student
     * @return
     */
    boolean editByid(Student student);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    boolean deleteById(int id);

    /**
     * 插入
     *
     * @param student
     * @return
     */
    boolean insert(Student student);

    /**
     * 按照文本模糊查找用户名
     *
     * @param txtsearch
     * @return
     */
    List<Student> findByLikeName(String txtsearch);

    /**
     * 获取students总数
     *
     * @return
     */
    int getCount();

    /**
     * 分页
     *
     * @param page
     * @return
     */
    List<Student> getStudentsByPage(PageIndexer page);


}
