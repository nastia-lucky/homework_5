package com.otus.homeWorkStub.controllers;

import com.otus.homeWorkStub.models.CourseModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
public class CourseController {

  @GetMapping(value = "/courses/get/all")
  public List<CourseModel> getAllCourses() {
    return new ArrayList<CourseModel>();
  }
}
