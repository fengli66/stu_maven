package com.lifeng.dao.student;

import com.lifeng.pojo.PageIndexer;
import com.lifeng.pojo.Student;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * studentMapper的实现类
 */
@Repository
public class StudentMapperImpl implements StudentMapper {

    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Student> findAll() {
        // TODO Auto-generated method stub
        List<Student> students = sqlSession.selectList("com.lifeng.dao.student.StudentMapper.findAll");
        return students;
    }

    @Override
    public Student findById(int id) {
        // TODO Auto-generated method stub
        Student student = sqlSession.selectOne("com.lifeng.dao.student.StudentMapper.findById", id);
        return student;
    }

    @Override
    public Student findByName(String name) {
        // TODO Auto-generated method stub
        Student student = sqlSession.selectOne("com.lifeng.dao.student.StudentMapper.findByName", name);
        return student;
    }

    @Override
    public boolean editByid(Student student) {
        // TODO Auto-generated method stub
        int i = sqlSession.update("com.lifeng.dao.student.StudentMapper.editByid", student);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteById(int id) {
        // TODO Auto-generated method stub
        int i = sqlSession.delete("com.lifeng.dao.student.StudentMapper.deleteById", id);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean insert(Student student) {
        // TODO Auto-generated method stub
        int i = sqlSession.insert("com.lifeng.dao.student.StudentMapper.insert", student);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Student> findByLikeName(String txtsearch) {
        // TODO Auto-generated method stub
        List<Student> students = sqlSession.selectList("com.lifeng.dao.student.StudentMapper.findByLikeName", txtsearch);
        return students;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        int count = sqlSession.selectOne("com.lifeng.dao.student.StudentMapper.getCount");
        return count;
    }


    @Override
    public List<Student> getStudentsByPage(PageIndexer page) {
        // TODO Auto-generated method stub
        List<Student> students = sqlSession.selectList("com.lifeng.dao.student.StudentMapper.getStudentsByPage", page);
        return students;
    }

}
