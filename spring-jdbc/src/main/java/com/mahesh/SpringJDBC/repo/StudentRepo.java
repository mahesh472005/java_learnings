package com.mahesh.SpringJDBC.repo;

import com.mahesh.SpringJDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class StudentRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save() {
        String sql = "insert into student (id,name,marks) values(6,'spiderman',89);";
        int rows  = jdbcTemplate.update(sql);
        System.out.println(rows + " added");
    }
    public List<Student> getAll() {

        RowMapper<Student> studentRowMapper = new RowMapper<>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setMarks(rs.getString("marks"));
                return student;
            }
        };

        String sql = "Select * From Student";
        List<Student> studentList = jdbcTemplate.query(sql, studentRowMapper);
        return  studentList;
    }
}
