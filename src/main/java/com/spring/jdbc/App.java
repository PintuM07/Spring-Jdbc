package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Program Started...............!" );
        
        ApplicationContext context = 
        		new AnnotationConfigApplicationContext(jdbcConfig.class);
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
    
//        -------------insert----------------
//        Student student = new Student();
//        student.setId(6);
//        student.setName("Rohan Mahato");
//        student.setAddress("Tulin");
//        
//        int result = studentDao.insert(student);
//        
//        System.out.println("student added " + result);
       //--------------------Update------------------------- 
//        Student student = new Student();
//        student.setId(6);
//        student.setName("Hrittik Mahato");
//        student.setAddress("Tulin");
//        
//        int result = studentDao.change(student);
//        
//        System.out.println("data changed " + result);
        
//        ----------------delete-----------------
//        int result = studentDao.delete(6);
//        System.out.println("deleted " + result );
        
//         -------------get Student------------
        
//        Student student = studentDao.getStudent(1);
//        System.out.println();

//    get all students-------------------------------
        
        List<Student> student = studentDao.listOfStudent();
        for (Student s : student) {
			System.out.println(s);
		}
    }
}
