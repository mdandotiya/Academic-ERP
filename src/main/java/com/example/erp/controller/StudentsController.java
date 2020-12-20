package com.example.erp.controller;

import com.example.erp.bean.Course_Schedule;
import com.example.erp.bean.Employees;
import com.example.erp.service.CourseService;
import com.example.erp.wrap.Wrapping;
import com.example.erp.bean.Courses;
import com.example.erp.bean.Students;
import com.example.erp.service.StudentService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Path("students")
public class StudentsController {
    StudentService studentService = new StudentService();
    CourseService courseService = new CourseService();

    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loginStudents(Students students) throws URISyntaxException{
        if(studentService.verifyEmail(students)){
            return Response.ok().build();
        }
        else {
            return Response.status(203).build();
        }
    }

    @POST
    @Path("/timetable")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCourses(Students students) throws URISyntaxException{
        List<Courses> coursesList = studentService.getCourses(students);
        if(coursesList.size() > 0){
            List<Course_Schedule> course_schedules = courseService.getschedule(coursesList);
            Employees employees = courseService.getEmployee(coursesList);
            return Response.ok().build();
        }
        else {
            return Response.status(203).build();
        }
    }
}
