package com.otus.homeWorkStub.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Objects;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel {

  public UserModel(String name, String course, String email, Integer age) {
    this.name = name;
    this.course = course;
    this.email = email;
    this.age = age;
  }

  public UserModel() {
  }

  public String getName() {
    return name;
  }

  public String getCourse() {
    return course;
  }

  public String getEmail() {
    return email;
  }

  public Integer getAge() {
    return age;
  }

  public void update(UserModel user) {
    setName(user.name);
    setAge(user.age);
    setCourse(user.course);
    setEmail(user.email);
  }

  @JsonProperty("name")
  private String name;

  @JsonProperty("course")
  private String course;

  @JsonProperty("email")
  private String email;

  @JsonProperty("age")
  private Integer age;

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;
    UserModel userModel = (UserModel) object;
    return Objects.equals(name, userModel.name) && Objects.equals(course, userModel.course) && Objects.equals(email, userModel.email) && Objects.equals(age, userModel.age);
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCourse(String course) {
    this.course = course;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, course, email, age);
  }
}
